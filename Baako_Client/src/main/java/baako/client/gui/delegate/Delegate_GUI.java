/**
 * 
 */
package baako.client.gui.delegate;

import java.util.Date;

import javax.swing.JOptionPane;
import baako.client.controller.BaakoController;
import baako.client.gui.GUI;
import baako.server.dto.PlainUserDTO;

/**
 * @author gusy
 *
 */
public class Delegate_GUI extends GUI{

	private BaakoController controller;

	public Delegate_GUI(BaakoController controller){
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
	
	public boolean  register(String email, String username, String password, Date date){
		System.out.println("VAMOS A REGISTRAR");
		PlainUserDTO u = new PlainUserDTO(email, username, password, date, null, null);
		System.out.println(u.getEmail());
		controller.register(u);
//		if(controller.register(username, password)){
//			return true;
//		}else{
//			new JOptionPane("YOU ARE ALREADY REGISTERED");
//			return false;
//		}
		return true;
	}
	
	

}
