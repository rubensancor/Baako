/**
 * 
 */
package baako.client.gui.delegate;

import javax.swing.JOptionPane;

import baako.client.controller.BaakoController;
import baako.client.gui.LoginWindow;
import baako.client.gui.MainWindow;

/**
 * @author gusy
 *
 */
public class Delegate_LoginWindow  extends LoginWindow{

	private BaakoController controller;

	public Delegate_LoginWindow(BaakoController controller){
			super();
			this.controller = controller;
	}
	
	public boolean logIn(String username, String password){
		if(controller.logIn(username, password)){
			
			new MainWindow();
			return true;
		}else{
			new JOptionPane("LOGIN FAILED");
			return false;
		}
	}
	
	public boolean register(String username, String password){
		if(controller.register(username, password)){
			return true;
		}else{
			new JOptionPane("YOU ARE ALREADY REGISTERED");
			return false;
		}
	}

}
