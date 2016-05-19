package baako.client;

import java.rmi.RMISecurityManager;

import baako.client.controller.BaakoController;
import baako.client.gui.delegate.Delegate_GUI;
import baako.client.remote.RMIServiceLocator;
/**
 * @author Baako-Team
 *
 */
@SuppressWarnings("deprecation")
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
	}
}