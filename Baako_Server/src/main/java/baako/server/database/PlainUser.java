/**
 * 
 */
package baako.server.database;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author gusy
 *
 */
public class PlainUser extends User {

	@Join
	private Set<PlainUser> friends;
	
	/* (non-Javadoc)
	 * @see baako.server.database.User#getUserId()
	 */
	@Override
	public int getUserId() {
		// TODO Auto-generated method stub
		return super.getUserId();
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


	/* (non-Javadoc)
	 * @see baako.server.database.User#getGames()
	 */
	@Override
	public List<Game> getGames() {
		// TODO Auto-generated method stub
		return super.getGames();
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

}
