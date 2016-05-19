package baako.server.database;

import java.util.HashSet;
import java.util.Set;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
/**
 * @brief Class that instanciates the categories of the games
 * @author Baako-Team
 *
 */
@PersistenceCapable(detachable="true")
public class Category {

	@PrimaryKey
	private String name;

	@Persistent(mappedBy="categories")
	private Set<Game> games;



	/**
	 * Constructor with the name of the category. It initiates a {@link HashSet} with zero {@link Game}s in it.
	 * @param name The name of the category
	 */
	public Category(String name) {
		super();
		this.name = name;
		games = new HashSet<Game>();
	}

	/**
	 *  Constructor with the name of the category and the {@link Game}s asociated to it
	 * @param name The name of the category
	 * @param games The games asociated to this category
	 */
	public Category(String name, HashSet<Game> games) {
		this.name = name;
		this.games = games;
	}

	/**
	 * Method that returns the name of the category
	 * @return the name of the category
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Method that returns the games with this category
	 * @return the games with this category
	 */
	public Set<Game> getGames() {
		return this.games;
	}

	/**
	 * Method that allows to add a game into the set of games of the category
	 * @param g The game to add
	 * @return
	 * 		<p>true - If the game is added correctly</p>
	 * 		<p>false - If it isn't</p>
	 */
	public boolean addGame(Game g){
		games.add(g);
		return true;
	}

	/**
	 * Method that returns the number of games asociated to this category
	 * @return The number of games asociated to this category
	 */
	public int getNumbGames(){
		return this.games.size();
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
//	@Override
//	public boolean equals(Object obj) {
//		boolean b = false;
//		if(obj != null)
//			if(obj instanceof Category){
//				Category c = (Category)obj;
//				b = this.name.equals(c.getName());
//			}
//		return b;
//	}
}
