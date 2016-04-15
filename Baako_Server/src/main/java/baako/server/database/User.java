package baako.server.database;

import java.util.Date;
import java.util.List;
import javax.jdo.annotations.Join;

//@PersistenceCapable(detachable="true")
public abstract class User {

//	@PrimaryKey
	private int userId;

	private String email;
	private String name;
	private Date birthdate;
	private String password;

	@Join
	private List<Game> games;


	public User(){

	}

	public User(int userId, String email, String name, Date birthdate){
		super();
		this.email = email;
		this.name = name;
		this.birthdate = birthdate;
		
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
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
		return name;
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

	/**
	 * @return the games
	 */
	public List<Game> getGames() {
		return games;
	}
	
	

}
