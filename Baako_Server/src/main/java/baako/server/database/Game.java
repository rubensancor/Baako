package baako.server.database;

import java.util.Set;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import baako.server.dto.GameDTO;
import baako.server.dto.UserDTO;

@PersistenceCapable(detachable="true")
public class Game {

	@PrimaryKey
	private String name;
	
	
	private float price;
	private String description;
	private int PEGI;
	
	


	@Persistent(table= "GAME_CATEGORIES")
	@Join(column="GAME_ID")
	@Element(column="CATEGORY_ID")
	private Set<Category> categories;
	
	@Persistent(table= "GAME_DESIGNERS")
	@Join(column="GAME_ID")
	@Element(column="DESIGNER_ID")
	private Set<Designer> designers;
	
	/**
	 * Constructor with all the classes
	 * @param name	The name of the game
	 * @param price	The price of the game
	 * @param description	The description of the game
	 * @param PEGI	The PEGI of the game
	 */
	public Game(String name, float price, String description, int PEGI) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.PEGI = PEGI;
		this.categories = null;
		this.designers = null;
	}
	
	
	/**
	 * Constructor that allows to create a new user from a {@link GameDTO} given
	 * @param user The {@link GameDTO} given
	 */
	public Game(GameDTO game) {
		this.name = game.getName();
		this.price = game.getPrice();
		this.description = game.getDescription();
		this.PEGI = game.getPEGI();
	}

	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the pEGI
	 */
	public int getPEGI() {
		return PEGI;
	}


	/**
	 * @param pEGI the pEGI to set
	 */
	public void setPEGI(int pEGI) {
		PEGI = pEGI;
	}


	/**
	 * @return the categories
	 */
	public Set<Category> getCategories() {
		return categories;
	}


	/**
	 * @param categories the categories to set
	 */
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}


	/**
	 * @return the designers
	 */
	public Set<Designer> getDesigners() {
		return designers;
	}


	/**
	 * @param designers the designers to set
	 */
	public void setDesigners(Set<Designer> designers) {
		this.designers = designers;
	}


	/**
	 * Method that adds a designer to the game
	 * @param designer the designer to add
	 */
	public void addDesigner(Designer designer){
		this.designers.add(designer);
	}
	
	/**
	 * Method that adds a category to the game
	 * @param category the designer to add
	 */
	public void addCategory(Category category){
		this.categories.add(category);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Game eq;
		if(obj instanceof Game)eq = (Game)obj; 
		else return false;
		if(!eq.getName().equals(name)) return false;
		else return true;
	}
	
}
