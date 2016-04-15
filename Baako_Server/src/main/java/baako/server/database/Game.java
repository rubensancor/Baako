package baako.server.database;

import java.util.List;
import java.util.Set;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")
public class Game {

	@PrimaryKey
	private int gameId;
	
	private String name;
	private float price;
	private String genre;
	private String description;
	private int PEGI;
	
	@Element(column="USERS_ID")
	private List<User> users;
	
	@Persistent(table= "GAME_CATEGORIES")
	@Join(column="gameId")
	@Element(column="gameId")
	List<Category> categories;
	
	/**
	 * @return the gameId
	 */
	public int getGameId() {
		return gameId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	
}
