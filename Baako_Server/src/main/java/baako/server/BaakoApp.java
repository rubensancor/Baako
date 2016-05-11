package baako.server;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.Date;

import baako.server.dao.BaakoDAO;
import baako.server.dao.IBaakoDAO;
import baako.server.database.Game;
import baako.server.database.PlainUser;
import baako.server.facade.BaakoFacade;
import baako.server.manager.IBaakoManager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import baako.server.assemblers.Assembler;
import baako.server.auth.Auth;
import baako.server.database.Category;
import baako.server.database.Designer;
import baako.server.database.Game;
import baako.server.database.PlainUser;
import baako.server.database.Wallet;
import baako.server.dto.GameDTO;
import baako.server.dto.PlainUserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 

/**
 *
 */
public class BaakoApp {
	static Logger logger = LoggerFactory.getLogger(BaakoApp.class);
		private Auth auth;
		private IBaakoDAO dao;
		/**
		 * @throws RemoteException
		 */
		public BaakoApp(IBaakoDAO dao) throws RemoteException {
			this.dao = (BaakoDAO) dao;
			auth = new Auth(dao);
		}
		
		public IBaakoDAO getDao() {
			return dao;
		}
		
		public Auth getAuth() {
			return auth;
		}

		public PlainUserDTO checkUserInfo(String username, String password) throws RemoteException {
			logger.info("Checking user info...");
			return auth.checkUserInfo(username, password);
		}

		public boolean register(PlainUserDTO user) throws RemoteException {
			logger.info("Registering user...");
			System.out.println(user.getEmail());
			System.out.println(Assembler.getInstance().assemble(user));
			return auth.register(Assembler.getInstance().assemble(user));
		}

		public boolean launchGame() throws RemoteException{
			// TODO Auto-generated method stub
			return false;
		}

		public boolean addWallet(int cardNumber, PlainUserDTO u) throws RemoteException{
			Wallet w = new Wallet(cardNumber);
			PlainUser user = Assembler.getInstance().assemble(u);
			dao.addWallet(w , user);
			return true;
		}

		public boolean addGame(GameDTO game) throws RemoteException{
			logger.info("ADD GAME FACADE");
			dao.addGame(Assembler.getInstance().disassemble(game));
			return true;
		}

		/* (non-Javadoc)
		 * @see baako.server.manager.IBaakoManager#getAllCategories()
		 */
		public ArrayList<String>  getAllCategories() throws RemoteException {
			ArrayList<Category> aux = dao.getAllCategories();
			ArrayList<String> aux2 = new ArrayList<String>();
			for (Category category : aux) {
				aux2.add(category.getName());
			}
			return aux2;	
		}

		/* (non-Javadoc)
		 * @see baako.server.manager.IBaakoManager#getAllDesigners()
		 */
		public ArrayList<String> getAllDesigners() throws RemoteException {
			ArrayList<Designer> aux = dao.getAllDesigners();
			ArrayList<String> aux2 = new ArrayList<String>();
			for (Designer designer : aux) {
				aux2.add(designer.getName());
			}
			return aux2;
		}

		public boolean buyGame(GameDTO g, PlainUserDTO u) throws RemoteException {
			Game game = dao.searchGame(Assembler.getInstance().disassemble(g).getName());
			PlainUser user = Assembler.getInstance().assemble(u);
			if(user.pay(game.getPrice()))
				dao.buyGame(game, user);
			return true;
		}

		public GameDTO searchGame(String name) throws RemoteException {
			return Assembler.getInstance().assemble(dao.searchGame(name));
		}

		public ArrayList<GameDTO> searchGamebyCategory(String category) throws RemoteException {
			ArrayList<Game> g = dao.searchGamesByCategory(category);
			ArrayList<GameDTO> dto = new ArrayList<GameDTO>();
			for (Game game : g) {
				dto.add(Assembler.getInstance().assemble(game));
			}
			return dto;
		}

		public ArrayList<GameDTO> searchGamebyDesigner(String designer) throws RemoteException {
			ArrayList<Game> g = dao.searchGamesByDesigner(designer);
			ArrayList<GameDTO> dto = new ArrayList<GameDTO>();
			for (Game game : g) {
				dto.add(Assembler.getInstance().assemble(game));
			}
			return dto;
		}

	
	@SuppressWarnings("deprecation")
	public static void main( String[] args ){
		if (args.length != 3) {
			System.out.println("How to invoke: java [policy] [codebase] Server.Server [host] [port] [server]");
			System.exit(0);
		}

		if(System.getSecurityManager()==null){
			System.setSecurityManager(new RMISecurityManager());
		}

		String serverName = "//"+args[0]+":"+args[1]+"/"+args[2];

		try{
			IBaakoDAO dao = new BaakoDAO();
			BaakoApp app = new BaakoApp(dao);
			IBaakoManager manager = new BaakoFacade(app);

			//			IAuth auth = new Auth(dao);

			//		    ArrayList<Game> games = (ArrayList<Game>) dao.getAllGames();
			//		    System.out.println(games);
			//			System.out.println("Email ----> "+dao.getUser("ruben").getEmail());

			PlainUser a = new PlainUser("a","a","a",new Date(95, 0, 19));
			//			PlainUser b = new PlainUser("a","b","a",new Date(95, 0, 19));
			//			PlainUser c = new PlainUser("a","c","a",new Date(95, 0, 19));
			Game g = new Game("asdf", 2, "asdf", 3);

			dao.addGame(g);
			dao.addUser(a); 
			dao.buyGame(g, a);
			//			dao.addUser(b);
			//			dao.addUser(c);
			//			dao.addFriend(a, b);
			//			dao.addFriend(a, c);


			Naming.rebind(serverName, manager);
			logger.info(serverName+ " active and waiting...");
			java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader ( System.in );
			java.io.BufferedReader stdin = new java.io.BufferedReader ( inputStreamReader );
			/*String line  = */stdin.readLine();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
