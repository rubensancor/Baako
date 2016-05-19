
package baako.server.database;

import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
/**
 * @brief  Class that instanciates the designers of the games
 * @author Baako-Team
 *
 */
@PersistenceCapable(detachable="true")
public class Designer {
	
	@PrimaryKey
	private String name;

	@Persistent(mappedBy="designers")
	private Set<Game> games;

	/**
	 * Constructor with the name of the designer. It initiates a {@link HashSet} with zero {@link Game}s in it.
	 * @param name The name of the designer
	 */
	public Designer(String name) {
		super();
		this.name = name;
		games = new HashSet<Game>();
	}
	
	/**
	 *  Constructor with the name of the designer and the {@link Game}s asociated to it
	 * @param name The name of the designer
	 * @param games The games asociated to this designer
	 */
	public Designer(String name, HashSet<Game> games) {
		this.name = name;
		this.games = games;
	}

	/**
	 * Method that returns the name of the designer
	 * @return the name of the designer
	 */
	public String getName() {		
		return name;
	}

	/**
	 * Method that returns the games with this designer
	 * @return the games with this designer
	 */
	public Set<Game> getGames() {
		return games;
	}
	
	/**
	 * Method that allows to add a game into the set of games of the designer
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
	 * Method that returns the number of games asociated to this designer
	 * @return The number of games asociated to this designer
	 */
	public int getNumbGames(){
		return games.size();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean b = false;
		if(obj != null)
			if(obj instanceof Designer){
				Designer c = (Designer)obj;
				b = this.name.equals(c.getName());
			}
		return b;
	}

}
