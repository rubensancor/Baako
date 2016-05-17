package baako.server.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import baako.server.database.Game;
import baako.server.database.PlainUser;
/**
 * @author Baako-Team
 *
 */
public class PlainUserDTO extends UserDTO implements Serializable{

	private static final long serialVersionUID = -6344367997349054739L;
	
	
	private Set<PlainUser> friends = new HashSet<PlainUser>();
	private Set<Game> games = new HashSet<Game>();

	public PlainUserDTO(String email, String name, String password, Date birthdate, Set<PlainUser> friends,
			Set<Game> games) {
		super(email, name, password, birthdate);
		this.friends = friends;
		this.games = games;
	}
	
	public PlainUserDTO(PlainUser u) {
		super(u);
		this.friends = u.getFriends();
		this.games = u.getGames();
	}
	
	public PlainUserDTO(String email, String name, String password, Date birthdate) {
		super(email, name, password, birthdate);
		this.friends = null;
		this.games = null;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public Set<PlainUser> getFriends() {
		return friends;
	}
	public void setFriends(Set<PlainUser> friends) {
		this.friends = friends;
	}
	/**
	 * @return the games
	 */
	public Set<Game> getGames() {
		return games;
	}
	/**
	 * @param games the games to set
	 */
	public void setGames(Set<Game> games) {
		this.games = games;
	}

}
