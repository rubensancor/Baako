package baako.server.database;

import java.util.List;
import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")
public class Designer {
	
	@PrimaryKey
	private String name;

	@Persistent(mappedBy="designers")
	private Set<Game> games;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the games
	 */
	public Set<Game> getGames() {
		return games;
	}
	
	
}
