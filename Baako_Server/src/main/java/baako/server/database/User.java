package baako.server.database;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import baako.server.dto.UserDTO;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.SUBCLASS_TABLE)
public abstract class User {


	@PrimaryKey
	protected String username;	
	protected String email;
	protected Date birthdate;
	protected String password;

	


	public User(){
	}

	public User(String email, String name, String password,  Date birthdate){
		super();
		this.email = email;
		this.username = name;
		this.password = password;
		this.birthdate = birthdate;	
	}
	
	public User(UserDTO user){
		this.email = user.getEmail();
		this.username = user.getUsername();
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
		return username;
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

	
	

}
