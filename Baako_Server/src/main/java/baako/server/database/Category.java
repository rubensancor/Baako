package baako.server.database;

import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 


@PersistenceCapable
public class Category {

	Logger logger = LoggerFactory.getLogger(Category.class);
	
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
		logger.info("Get name: "+name);
		return this.name;
	}
	
	public Set<Game> getGames() {
		logger.info("Set games");
		return this.games;
	}
	
	public boolean addGame(Game g){
		logger.info("addGame");
		games.add(g);
		return true;
	}
	
	public int getNumbGames(){
		logger.info("getNumberofGames");
		return this.games.size();
	}
	
}
