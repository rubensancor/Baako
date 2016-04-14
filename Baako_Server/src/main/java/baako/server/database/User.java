package baako.server.database;

import java.util.Date;

//@PersistenceCapable(detachable="true")
public class User {

//	@PrimaryKey
	private int userId;


	private String email;
	private String name;
	private Date birthdate;
	private UserType type;



	public User(){

	}

	public User(int userId, String email, String name, Date birthdate, UserType type){
		super();
		this.email = email;
		this.name = name;
		this.birthdate = birthdate;
		
	}

}
