/**
 * 
 */
package baako.client.gui.delegate;

import java.awt.TrayIcon.MessageType;

import javax.swing.JOptionPane;

import baako.client.controller.BaakoController;
import baako.client.gui.LoginWindow;
import baako.client.gui.MainWindow;
import baako.server.database.PlainUser;

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
		System.out.println("asdfasdf");
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
		new Delegate_RegisterWindow(this);
	}

}
