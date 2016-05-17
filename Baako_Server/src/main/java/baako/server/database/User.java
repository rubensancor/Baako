package baako.server.database;

import java.util.Date;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import baako.server.dto.UserDTO;
/**
 * @brief The users of Baako
 * @author Baako-Team
 *
 */
 
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.SUBCLASS_TABLE)
public abstract class User {


	@PrimaryKey
	protected String username;	
	protected String email;
	protected Date birthdate;
	protected String password;

	
	/**
	 * Constructor with all the parameters
	 * @param email The email of the user
	 * @param name	The name of the user
	 * @param password	The password of the user
	 * @param birthdate	The birthdate of the user
	 */
	public User(String email, String name, String password,  Date birthdate){
		this.email = email;
		this.username = name;
		this.password = password;
		this.birthdate = birthdate;	
	}
	
	/**
	 * Constructor that allows to create a new user from a {@link UserDTO} given
	 * @param user The {@link UserDTO} given
	 */
	public User(UserDTO user){
		this.email = user.getEmail();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.birthdate = user.getBirthdate();
	}


	/**
	 * Method that returns the email of the user
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Method that returns the name of the user
	 * @return the name
	 */
	public String getName() {
		return username;
	}

	/**
	 * Method that return the birthdate of the user
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * Method that returns the password of the user
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
}
