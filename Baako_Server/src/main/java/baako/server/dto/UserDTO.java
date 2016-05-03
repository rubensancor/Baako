/**
 * 
 */
package baako.server.dto;

import java.io.Serializable;
import java.util.Date;

import baako.server.database.User;

/**
 * @author gusy
 *
 */
public abstract class UserDTO implements Serializable{

	private static final long serialVersionUID = -398423872161030910L;


	protected String name;	
	protected String email;
	protected Date birthdate;
	protected String password;

	public UserDTO(){
	}

	public UserDTO(String email, String name, String password,  Date birthdate){
		this.email = email;
		this.name = name;
		this.password = password;
		this.birthdate = birthdate;
	}

	public UserDTO(User user){
		this.email = user.getEmail();
		this.name = user.getName();
		this.password = user.getPassword();
		this.birthdate = user.getBirthdate();
	}

	public String getUsername() {
		return name;
	}

	public void setUsername(String username) {
		this.name = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
