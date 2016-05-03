package baako.server.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import baako.server.database.Game;
import baako.server.database.PlainUser;

public class PlainUserDTO implements Serializable{

	private static final long serialVersionUID = -4098700185966364385L;
	
	
	private String email;
	private String name;
	private Date birthdate;
	private String password;
	private Set<PlainUser> friends = new HashSet<PlainUser>();
	private Set<Game> games = new HashSet<Game>();

	public PlainUserDTO(String email, String name, Date birthdate, Set<PlainUser> friends, String password, Set<Game> games) {
		super();
		this.email = email;
		this.name = name;
		this.birthdate = birthdate;
		this.friends = friends;
		this.password = password;
		this.games = games;
	}
	
	public PlainUserDTO(PlainUser user){
		this.email = user.getEmail();
		this.name = user.getName();
		this.birthdate = user.getBirthdate();
		this.friends = user.getFriends();
		this.password = user.getPassword();
		this.games = user.getGames();
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
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
