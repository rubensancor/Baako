package baako.client;

import java.rmi.RMISecurityManager;

import baako.client.controller.BaakoController;
import baako.client.gui.GUI;
import baako.client.gui.LoginWindow;
import baako.client.gui.delegate.Delegate_GUI;
import baako.client.remote.RMIServiceLocator;
/**
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		if (System.getSecurityManager() == null) {

			System.setSecurityManager(new RMISecurityManager());
		}

		RMIServiceLocator rmi = new RMIServiceLocator(args[0], args[1], args[2]);
		BaakoController controller = new BaakoController(rmi);
		new Delegate_GUI(controller);
		//		try {
		//			String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
		//			IAuth auth = (IAuth) java.rmi.Naming.lookup(name);
		//			new Delegate_LoginWindow(controller);
		//			// Register to be allowed to send messages
		////			auth.register("Ruben", "1234");
		//			System.out.println("* Message coming from the server: '");
		//			
		//		} catch (Exception e) {
		//			System.err.println("Client to server fail: " + e.getMessage());
		//			e.printStackTrace();
		//		}
		//    }
	}
}
