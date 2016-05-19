package baako.server.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import baako.server.database.Category;
import baako.server.database.Designer;
import baako.server.database.Game;
/**
 * @author Baako-Team
 *
 */
public class GameDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private float price;
	private String description;
	private int PEGI;
	private String url;

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	private Set<Category> categories = new HashSet<Category>();
	private Set<Designer> designers = new HashSet<Designer>();
	private ArrayList<String> categoriesString = new ArrayList<String>();
	private ArrayList<String> designersString = new ArrayList<String>();


	public GameDTO() {
		super();
	}
	public GameDTO(String name, float price, String description, int pegi, String url ,Set<Category> categories, Set<Designer> designers) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.PEGI = pegi;
		this.url = url;
		this.setCategories(categories);
		this.setDesigners(designers);
	}
	public GameDTO(Game game) {
		this.name = game.getName();
		this.price = game.getPrice();
		this.description = game.getDescription();
		this.PEGI = game.getPEGI();
		this.url = game.getUrl();
		this.setCategories(game.getCategories());
		this.setDesigners(game.getDesigners());
	}

	public GameDTO(String name, float price, String description, int pegi, String url ,ArrayList<String> categories, ArrayList<String> designers) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.PEGI = pegi;
		this.url = url;
		this.categoriesString = categories;
		this.designersString = designers;
	}

	public GameDTO(GameDTO game) {
		this.name = game.getName();
		this.price = game.getPrice();
		this.description = game.getDescription();
		this.PEGI = game.getPEGI();
		this.url  = game.getUrl();
		for (String string : game.getCategoriesString()) {
			Category aux = new Category(string);
			this.categories.add(aux);
		}
		for (String string : game.getDesignersString()) {
			Designer aux = new Designer(string);
			this.designers.add(aux);
			System.out.println("Diseñadores"+this.designers.toString());
		}
	}

	public GameDTO(String name, float price, String description, int pegi) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.PEGI = pegi;
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
	
	

	/**
	 * @return the categoriesString
	 */
	public ArrayList<String> getCategoriesString() {
		return categoriesString;
	}
	/**
	 * @param categoriesString the categoriesString to set
	 */
	public void setCategoriesString(ArrayList<String> categoriesString) {
		this.categoriesString = categoriesString;
	}
	/**
	 * @return the designersString
	 */
	public ArrayList<String> getDesignersString() {
		return designersString;
	}
	/**
	 * @param designersString the designersString to set
	 */
	public void setDesignersString(ArrayList<String> designersString) {
		this.designersString = designersString;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}

}
