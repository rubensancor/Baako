package baako.server;

import java.rmi.Naming;

import baako.server.auth.Auth;

/**
 *
 */
public class Server {

	public static void main( String[] args ){
		if(System.getSecurityManager()==null){
			System.setSecurityManager(new SecurityManager());
		}

		String serverName = "//"+args[0]+":"+args[1]+"/"+args[2];

		try{
			Auth a = new Auth();
			Naming.rebind(serverName, a);
			a.register("Ruben","1234");			
		}catch (Exception e){
			e.printStackTrace();
		}
		System.out.println("Auth Server "+ serverName+ " active and waiting...");
	}   
}
