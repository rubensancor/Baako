package baako.client;

import java.rmi.RMISecurityManager;

import baako.client.gui.LoginWindow;
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
			LoginWindow lw = new LoginWindow();
			// Register to be allowed to send messages
//			auth.register("Ruben", "1234");
			System.out.println("* Message coming from the server: '");
			
		} catch (Exception e) {
			System.err.println("Client to server fail: " + e.getMessage());
			e.printStackTrace();
		}
    }
}
