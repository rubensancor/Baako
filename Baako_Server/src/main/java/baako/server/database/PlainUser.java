/**
 * 
 */
package baako.server.database;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;

/**
 * @author gusy
 *
 */
@PersistenceCapable
public class PlainUser extends User {

	@Join
	private Set<PlainUser> friends;
	
	@Join
	private Set<Game> games;
	
	 /**
	 * 
	 */
	public PlainUser(String email, String name, String password,  Date birthdate) {
		super(email,name,password,birthdate);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public PlainUser() {
	}

	/* (non-Javadoc)
	 * @see baako.server.database.User#getEmail()
	 */
	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	/* (non-Javadoc)
	 * @see baako.server.database.User#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	/* (non-Javadoc)
	 * @see baako.server.database.User#getBirthdate()
	 */
	@Override
	public Date getBirthdate() {
		// TODO Auto-generated method stub
		return super.getBirthdate();
	}

	/* (non-Javadoc)
	 * @see baako.server.database.User#getPassword()
	 */
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}


	public Set<Game> getGames() {
		// TODO Auto-generated method stub
		return games;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	/**
	 * @return the friends
	 */
	public Set<PlainUser> getFriends() {
		return friends;
	}

	public boolean buyGame(Game game){
		//Code for buying a game
		System.out.println(game+" purchased");
		return true;
	}
}
