package baako.server.database;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

public class Designer {
	
	@PrimaryKey
	private int designerId;
	
	private String name;

	/**
	 * @return the designerId
	 */
	public int getDesignerId() {
		return designerId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	
}
