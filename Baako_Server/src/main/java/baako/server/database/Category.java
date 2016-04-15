package baako.server.database;

import java.util.List;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Category {

	
	@PrimaryKey
	private String name;
	
	@Persistent(mappedBy="categories")
	List<Game> games;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	
}
