/**
 * 
 */
package baako.client.gui.delegate;

import java.util.Date;

import baako.client.gui.LoginWindow;
import baako.client.gui.RegisterWindow;
import baako.server.database.PlainUser;
/**
 * @author gusy
 *
 */
public class Delegate_RegisterWindow extends RegisterWindow{

	private LoginWindow log;
	
	public Delegate_RegisterWindow(LoginWindow log){
		super();
		this.log = log;
	}

	public void  register(Date birthdate){
		String password = new String(passwordField.getPassword().toString());
		System.out.println(tfEmail.getText());
		PlainUser aux = new PlainUser(tfEmail.getText(), tfUsername.getText(), password, birthdate, null, null);
		System.out.println("DELEGATE RW");
		System.out.println(aux.getName());
		log.register(aux);
	}
}
