package baako.server.dto;

import baako.server.database.Game;

public class GameDTO {
	
	private String name;
	private float price;
	private String description;
	private int PEGI;
	public GameDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GameDTO(String name, float price, String description, int pEGI) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		PEGI = pEGI;
	}
	public GameDTO(Game game) {
		this.name = game.getName();
		this.price = game.getPrice();
		this.description = game.getDescription();
		this.PEGI = game.getPEGI();
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
	public void setPEGI(int pEGI) {
		PEGI = pEGI;
	}
	
	@Override
	public boolean equals(Object obj) {
		GameDTO eq;
		if(obj instanceof GameDTO)eq = (GameDTO)obj; 
		else return false;
		if(!eq.getName().equals(name)) return false;
		else return true;
	}

}
