package baako.server.database;

import java.util.Date;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import baako.server.dto.UserDTO;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.SUBCLASS_TABLE)
public abstract class User {


	@PrimaryKey
	private String username;	
	protected String email;
	protected Date birthdate;
	protected String password;

	
	public User(String email, String name, String password,  Date birthdate){
		super();
		this.email = email;
		this.setUsername(name);
		this.password = password;
		this.birthdate = birthdate;	
	}
	
	public User(UserDTO user){
		this.email = user.getEmail();
		this.setUsername(user.getUsername());
		this.password = user.getPassword();
		this.birthdate = user.getBirthdate();
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return getUsername();
	}

	/**
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	

}
