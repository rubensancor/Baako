package baako.server.database;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Category {

	
	@PrimaryKey
	private String name;
	
	@Persistent(mappedBy="categories")
	private Set<Game> games;

	
	
	public Category(String name) {
		super();
		this.name = name;
		games = new HashSet<Game>();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
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
