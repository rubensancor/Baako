package baako.server.dto;

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

}
