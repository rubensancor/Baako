package baako.server.database;

import java.util.List;
import java.util.Set;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Game {

	@PrimaryKey
	private String name;
	
	
	private float price;
	private String description;
	private int PEGI;
	
//	@Element(column="USERS_ID")
//	private List<User> users;
	
	@Persistent(table= "GAME_CATEGORIES")
	@Join(column="GAME_ID")
	@Element(column="CATEGORY_ID")
	private Set<Category> categories;
	
	@Persistent(table= "GAME_DESIGNERS")
	@Join(column="GAME_ID")
	@Element(column="DESIGNER_ID")
	private Set<Designer> designers;
	
	/**
	 * 
	 */
	public Game(String name, float price, String description, int PEGI) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.PEGI = PEGI;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @return the pEGI
	 */
	public int getPEGI() {
		return PEGI;
	}
//	/**
//	 * @return the users
//	 */
//	public Set<User> getUsers() {
//		return users;
//	}
	/**
	 * @return the categories
	 */
	public Set<Category> getCategories() {
		return categories;
	}
	/**
	 * @return the designers
	 */
	public Set<Designer> getDesigners() {
		return designers;
	}
	
	
}
