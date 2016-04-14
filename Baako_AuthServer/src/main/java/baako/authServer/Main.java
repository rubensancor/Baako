package baako.authserver.main;

import java.rmi.Naming;


public class Main {

	public static void main(String[] args) {
		if(System.getSecurityManager()==null){
			System.setSecurityManager(new SecurityManager());
		}
		
		String serverName = "//"+args[0]+":"+args[1]+"/"+args[2];
		
		try{
			baako.authserver.remote.AuthServer a = new AuthServer();
			Naming.rebind(serverName, a);
			a.register("Gaizka","1234");
			a.register("ruben","asdf");			
		}catch (Exception e){
			e.printStackTrace();
		}
		System.out.println("Auth Server "+ serverName+ " active and waiting...");
	}
}
