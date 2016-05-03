/**
 * 
 */
package baako.server.database;

import java.util.Date;
import java.util.Set;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;

import baako.server.dto.PlainUserDTO;

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
	public PlainUser(String email, String name, String password, Date birthdate, Set<PlainUser> friends,
			Set<Game> games) {
		super(email, name, password, birthdate);
		this.friends = friends;
		this.games = games;
	}

	/**
	 * 
	 */
	public PlainUser(PlainUserDTO u) {
		super(u);
		this.friends = u.getFriends();
		this.games = u.getGames();
	}

	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}

	public void setFriends(Set<PlainUser> friends) {
		this.friends = friends;
	}

	/**
	 * @return the friends
	 */
	public Set<PlainUser> getFriends() {
		return friends;
	}

	public boolean buyGame(Game game) {
		// Code for buying a game
		System.out.println(game + " purchased");
		return true;
	}
}
