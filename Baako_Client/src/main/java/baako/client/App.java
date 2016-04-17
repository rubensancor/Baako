package baako.client;

import java.rmi.RMISecurityManager;
import baako.server.auth.IAuth;
/**
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	if (args.length != 3) {
			System.out.println("Use: java [policy] [codebase] Client.Client [host] [port] [server]");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		
		try {
			String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
			IAuth auth = (IAuth) java.rmi.Naming.lookup(name);
			// Register to be allowed to send messages
			auth.register("Ruben", "1234");
//			System.out.println("* Message coming from the server: '" + auth.sayMessage("dipina", "dipina", "This is a test!") + "'");
			
		} catch (Exception e) {
			System.err.println("Client to server fail: " + e.getMessage());
			e.printStackTrace();
		}
    }
}
