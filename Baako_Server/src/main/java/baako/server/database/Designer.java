package baako.server.database;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Designer {
	
	@PrimaryKey
	private String name;

	@Persistent(mappedBy="designers")
	private Set<Game> games;

	
	public Designer(String name) {
		this.name = name;
		games = new HashSet<Game>();
	}

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
	
	public boolean addGame(Game g){
		games.add(g);
		return true;
	}
	
	public int getNumbGames(){
		return games.size();
	}
}
