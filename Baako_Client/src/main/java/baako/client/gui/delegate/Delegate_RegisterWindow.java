/**
 * 
 */
package baako.client.gui.delegate;

import java.util.Date;

import baako.client.controller.BaakoController;
import baako.client.gui.RegisterWindow;
import baako.server.database.PlainUser;

/**
 * @author gusy
 *
 */
public class Delegate_RegisterWindow extends RegisterWindow{

	private BaakoController controller;

	public Delegate_RegisterWindow(BaakoController controller){
		super();
		this.controller = controller;
	}
	
	public void  register(Date birthdate){
		String password = new String(passwordField.getPassword().toString());
		PlainUser aux = new PlainUser(tfEmail.getText(), tfUsername.getText(), password, birthdate);
		System.out.println("DELEGATE RW");
		System.out.println(aux.getName());
		controller.register(aux);
		
	}
}
