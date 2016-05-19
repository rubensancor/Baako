package baako.server;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

import baako.server.database.Game;
import baako.server.database.News;
import baako.server.database.PlainUser;
import baako.server.facade.BaakoFacade;
import baako.server.manager.IBaakoManager;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;

import baako.server.assemblers.Assembler;
import baako.server.auth.Auth;
import baako.server.dao.BaakoDAO;
import baako.server.dao.IBaakoDAO;
import baako.server.database.Category;
import baako.server.database.Designer;
import baako.server.database.Wallet;
import baako.server.dto.GameDTO;
import baako.server.dto.NewsDTO;
import baako.server.dto.PlainUserDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 

/**
 * @author Baako-Team
 *
 */
@SuppressWarnings("deprecation")
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
		System.out.println(Assembler.getInstance().disassemble(user));
		return auth.register(Assembler.getInstance().disassemble(user));
	}

	public boolean launchGame() throws RemoteException{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addWallet(int cardNumber, PlainUserDTO u) throws RemoteException{
		Wallet w = new Wallet(cardNumber);
		PlainUser user = Assembler.getInstance().disassemble(u);
		dao.addWallet(w , user);
		return true;
	}

	public boolean addGame(GameDTO game) throws RemoteException{
		logger.info(game.getCategories().toString());
		logger.info(game.getDesigners().toString());
		dao.addGame(Assembler.getInstance().disassemble(game));
		return true;
	}

	/* (non-Javadoc)
	 * @see baako.server.manager.IBaakoManager#getAllCategories()
	 */
	public ArrayList<String>  getAllCategories() throws RemoteException {
		ArrayList<Category> aux = dao.getAllCategories();
		logger.info(aux.get(0).getName());
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
	
	public ArrayList<NewsDTO> getAllNews() throws RemoteException{
		ArrayList<News> aux = dao.getAllNews();
		ArrayList<NewsDTO> aux2 = new ArrayList<NewsDTO>();
		for (News news : aux) {
			aux2.add(new NewsDTO(news));
		}
		logger.info(aux.get(0).getTitle());
		return aux2;
	}

	public boolean buyGame(GameDTO g, PlainUserDTO u) throws RemoteException {
		Game game = Assembler.getInstance().disassemble(g);
		PlainUser user = Assembler.getInstance().disassemble(u);
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
	/**
	 * @param n
	 * @return
	 */
	public boolean addNews(NewsDTO n) {
		dao.addNews(Assembler.getInstance().assemble(n));
		return true;
	}


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


			//		    ArrayList<Game> games = (ArrayList<Game>) dao.getAllGames();
			//		    System.out.println(games);
			//			System.out.println("Email ----> "+dao.getUser("ruben").getEmail());
			//			PlainUser a = new PlainUser("a","a","a",new Date(95, 0, 19));
			//			PlainUser b = new PlainUser("a","b","a",new Date(95, 0, 19));
			//			PlainUser c = new PlainUser("a","c","a",new Date(95, 0, 19));
			//			Game g = new Game("asdf", 2, "asdf", 3);


			//			dao.addGame(g);
			//			dao.addUser(a); 
			//			dao.buyGame(g, a);
			//			dao.addUser(b);
			//			dao.addUser(c);
			//			dao.addFriend(a, b);
			//			dao.addFriend(a, c);
			//			Designer d = new Designer("EA");
			//			Designer d2 = new Designer("Ubisoft");
			//			HashSet<Designer> designers = new HashSet<Designer>();
			//			designers.add(d);
			//			designers.add(d2);
			//
			//			Category c = new Category("Shooter");
			//			Category c2 = new Category("MMORPG");
			//			HashSet<Category> categories = new HashSet<Category>();
			//			categories.add(c);
			//			categories.add(c2);
			//
			//			Game g = new Game("asdf", 2, "asdf", 3);
			//			g.setCategories(categories);
			//			g.setDesigners(designers);


			//			News n = new News("tere", new Date(90, 3, 12), "asdf");
			//			News n2 = new News("tere", new Date(90, 3, 12), "asdf");

			//			dao.addNews(n);
			//			dao.addNews(n2);

			//			dao.addGame(g);

			//			dao.buyGame(g, a);
			Naming.rebind(serverName, manager);
			logger.info(serverName+ " active and waiting...");
			java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader ( System.in );
			java.io.BufferedReader stdin = new java.io.BufferedReader ( inputStreamReader );
			/*String line  = */stdin.readLine();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @param user
	 * @return
	 */
	public ArrayList<GameDTO> getUserGames(PlainUserDTO user) {
//		logger.info(user.getName()+" "+user.getEmail());
//		return new ArrayList<GameDTO>(user.getGames());
		logger.info("Woohoo");
		PlainUser u = (PlainUser) dao.getUser(user.getName());
		HashSet<Game> games = (HashSet<Game>) u.getGames();
		ArrayList<GameDTO> dtoGames = new ArrayList<GameDTO>();
		for (Game game : games) {
			logger.info(game.getName()+" "+game.getDescription());
			dtoGames.add(Assembler.getInstance().assemble(game));
		}
		return dtoGames;
	}

	/**
	 * @return
	 */
	public ArrayList<GameDTO> getAllGames() {
		ArrayList<Game> aux = dao.getAllGames();
		ArrayList<GameDTO> aux2 = new ArrayList<GameDTO>();
		for (Game game : aux) {
			aux2.add(Assembler.getInstance().assemble(game));
		}
		return aux2;
	}

	/**
	 * @param user
	 * @param newFriend
	 * @return
	 */
	public boolean addFriend(PlainUserDTO user, PlainUserDTO newFriend) {
		dao.addFriend(Assembler.getInstance().disassemble(user), Assembler.getInstance().disassemble(newFriend));
		return true;
	}

	/**
	 * @param user
	 * @param oldFriend
	 * @return
	 */
	public boolean deleteFriend(PlainUserDTO user, PlainUserDTO oldFriend) {
		dao.deleteFriend(Assembler.getInstance().disassemble(user), Assembler.getInstance().disassemble(oldFriend));
		return true;
	}

	/**
	 * @return
	 */
	public ArrayList<PlainUserDTO> getAllUsers() {
		ArrayList<PlainUser> aux = dao.getAllUsers();
		ArrayList<PlainUserDTO> aux2 = new ArrayList<PlainUserDTO>();
		for (PlainUser user: aux) {
			aux2.add(new PlainUserDTO(user));
		}
		return aux2;
	}

	/**
	 * @param name
	 * @param price
	 * @param text
	 * @param pegi
	 * @param values2
	 * @param values4
	 * @return 
	 */
	public boolean editGame(String name, int price, String text, int pegi, ArrayList<String> values2,
			ArrayList<String> values4) {
		
	}


}
