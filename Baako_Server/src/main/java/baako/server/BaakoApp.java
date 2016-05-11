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


/**
 *
 */
public class BaakoApp {

	private static  IBaakoDAO dao;

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
			dao = new BaakoDAO();
			IBaakoManager manager = new BaakoFacade(dao);

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
			System.out.println("Baako Server "+ serverName+ " active and waiting...");
			java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader ( System.in );
			java.io.BufferedReader stdin = new java.io.BufferedReader ( inputStreamReader );
			String line  = stdin.readLine();

			//			a.register("Ruben","1234");			
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
