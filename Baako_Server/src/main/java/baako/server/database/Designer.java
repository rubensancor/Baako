package baako.server.database;

import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

public class Designer {
	
	@PrimaryKey
	private String name;

	@Persistent(mappedBy="designers")
	List<Game> games;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the games
	 */
	public List<Game> getGames() {
		return games;
	}
	
	
}
