package baako.server;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import baako.server.auth.Auth;
import baako.server.auth.IAuth;
import baako.server.dao.BaakoDAO;
import baako.server.dao.IBaakoDAO;
import baako.server.database.Game;
import baako.server.database.PlainUser;
import baako.server.database.User;
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
			
			Naming.rebind(serverName, manager);
			System.out.println("Auth Server "+ serverName+ " active and waiting...");
			java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader ( System.in );
			java.io.BufferedReader stdin = new java.io.BufferedReader ( inputStreamReader );
			String line  = stdin.readLine();
			
//			a.register("Ruben","1234");			
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
