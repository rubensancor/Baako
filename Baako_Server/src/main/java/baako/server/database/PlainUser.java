/**
 * 
 */
package baako.server.database;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.FetchPlan;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import baako.server.dto.PlainUserDTO;

/**
 * @author gusy
 *
 */
@PersistenceCapable(detachable="true")
public class PlainUser extends User {


	@Persistent(table="PLAINUSER_FRIEND")
	@Join(column="PLAINUSER_ID_A")
	@Element(column="PLAINUSER_ID_B")
	private Set<PlainUser> friends;

	@Persistent(table="PLAINUSER_GAMES")
	@Join(column="PLAINUSER_ID")
	@Element(column="GAME_ID")
	private Set<Game> games;

	@Column(name="WALLET_ID")
	private Wallet wallet;

	/**
	 * 
	 */
	public PlainUser(String email, String name, String password, Date birthdate, Set<PlainUser> friends, Set<Game> games, Wallet wallet) {
		super(email, name, password, birthdate);
		this.friends = friends;
		this.games = games;
		this.wallet = wallet;
	}

	public PlainUser(String email, String name, String password, Date birthdate) {
		super(email, name, password, birthdate);
		this.friends = new HashSet<PlainUser>();
		this.games = new HashSet<Game>();
		this.wallet = null;
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
		this.games.add(g);
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

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public boolean pay(float money){
		// OMG CRAZY ASF PAYING STUFF
		return true;
	}

}
