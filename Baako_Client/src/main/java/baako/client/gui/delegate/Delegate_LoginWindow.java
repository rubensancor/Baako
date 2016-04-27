/**
 * 
 */
package baako.client.gui.delegate;

import javax.swing.JOptionPane;
import baako.client.controller.BaakoController;
import baako.client.gui.GUI;
import baako.client.gui.LoginWindow;
import baako.server.database.PlainUser;

/**
 * @author gusy
 *
 */
public class Delegate_LoginWindow  extends GUI{

	private BaakoController controller;

	public Delegate_LoginWindow(BaakoController controller){
			super(1);
			this.controller = controller;
	}
	
	public boolean logIn(String username, String password){
		if(controller.logIn(username, password)){
			new Delegate_MainWindow();
			return true;
		}else{
			new JOptionPane("ERROR IN THE LOGIN",1);
			return false;
		}
	}
	
	public void register(PlainUser u){
		System.out.println("VAMOS A REGISTRAR");
		System.out.println(u.getEmail());
//		controller.register();
//		if(controller.register(username, password)){
//			return true;
//		}else{
//			new JOptionPane("YOU ARE ALREADY REGISTERED");
//			return false;
//		}
	}
	
	public void newRegister(){
		new GUI(0);
	}
	
	public void cancel(){
			new GUI(1);
	}

}
