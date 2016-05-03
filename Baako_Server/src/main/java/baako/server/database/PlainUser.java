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
	public PlainUser(String email, String name, String password, Date birthdate, Set<PlainUser> friends,Set<Game> games) {
		super(email, name, password, birthdate);
		this.friends = friends;
		this.games = games;
	}

	public PlainUser(String email, String name, String password, Date birthdate) {
		super(email, name, password, birthdate);
		this.friends = null;
		this.games = null;
	}

	/**
	 * 
	 */
	public PlainUser(PlainUserDTO u) {
		super(u.getEmail(), u.getName(), u.getPassword(), u.getBirthdate());
		this.friends = u.getFriends();
		this.games = u.getGames();
	}

	public PlainUser(PlainUser u){
		super(u.getEmail(), u.getName(), u.getPassword(), u.getBirthdate());
		this.friends = u.getFriends();
		this.games = u.getGames();	
	}


	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}


	public void addGame(Game g){
		games.add(g);
	}

	public void addFriend(PlainUser u){
		friends.add(u);
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

	@Override
	public String toString() {
		return "User: "+username;
	}

	//	public boolean buyGame(Game game) {
	//		// Code for buying a game
	//		System.out.println(game + " purchased");
	//		return true;
	//	}
}
