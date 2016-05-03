package baako.server.dto;

import java.util.HashSet;
import java.util.Set;

import baako.server.database.Category;
import baako.server.database.Designer;
import baako.server.database.Game;

public class GameDTO {
	
	private String name;
	private float price;
	private String description;
	private int PEGI;
	
	private Set<Category> categories = new HashSet<Category>();
	private Set<Designer> designers = new HashSet<Designer>();
	
	
	public GameDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GameDTO(String name, float price, String description, int pegi, Set<Category> categories, Set<Designer> designers) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.PEGI = pegi;
		this.setCategories(categories);
		this.setDesigners(designers);
	}
	public GameDTO(Game game) {
		this.name = game.getName();
		this.price = game.getPrice();
		this.description = game.getDescription();
		this.PEGI = game.getPEGI();
		this.setCategories(game.getCategories());
		this.setDesigners(game.getDesigners());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPEGI() {
		return PEGI;
	}
	public void setPEGI(int pegi) {
		PEGI = pegi;
	}
	
	@Override
	public boolean equals(Object obj) {
		GameDTO eq;
		if(obj instanceof GameDTO)eq = (GameDTO)obj; 
		else return false;
		if(!eq.getName().equals(name)) return false;
		else return true;
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

}
