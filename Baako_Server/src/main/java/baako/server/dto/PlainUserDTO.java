package baako.server.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import baako.server.database.PlainUser;
/**
 * @author Baako-Team
 *
 */
public class PlainUserDTO extends UserDTO implements Serializable{

	private static final long serialVersionUID = -6344367997349054739L;


	private Set<PlainUserDTO> friends;
	private Set<GameDTO> games;

	public PlainUserDTO(String email, String name, String password, Date birthdate, Set<PlainUserDTO> friends,
			Set<GameDTO> games) {
		super(email, name, password, birthdate);
		this.friends = friends;
		this.games = games;
	}

	public PlainUserDTO(PlainUser u) {
		super(u);
		friends = new HashSet<PlainUserDTO>();
//		if(!u.getFriends().isEmpty())
//			for (PlainUser friend : u.getFriends()) 
//				this.friends.add(Assembler.getInstance().assemble(friend));

		games = new HashSet<GameDTO>();
//		if (!u.getGames().isEmpty()) 
//			for (Game game: u.getGames()) 
//				this.games.add(Assembler.getInstance().assemble(game));

	}

	public PlainUserDTO(String email, String name, String password, Date birthdate) {
		super(email, name, password, birthdate);
		this.friends  = new HashSet<PlainUserDTO>();
		this.games = new HashSet<GameDTO>();
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
	public Set<PlainUserDTO> getFriends() {
		return friends;
	}
	public void setFriends(Set<PlainUserDTO> friends) {
		this.friends = friends;
	}

	/**
	 * @return the games
	 */
	public Set<GameDTO> getGames() {
		return games;
	}
	/**
	 * @param games the games to set
	 */
	public void setGames(Set<GameDTO> games) {
		this.games = games;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}

}
