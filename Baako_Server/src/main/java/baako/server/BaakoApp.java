package baako.server;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import baako.server.auth.Auth;
import baako.server.auth.IAuth;
import baako.server.dao.BaakoDAO;
import baako.server.dao.IBaakoDAO;

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
			IAuth auth = new Auth(dao);
//			System.out.println("Email ----> "+dao.getUser("Ruben").getEmail());
			Naming.rebind(serverName, auth);
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
