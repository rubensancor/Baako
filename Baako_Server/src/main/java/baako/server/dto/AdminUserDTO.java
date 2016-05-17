package baako.server.dto;

import java.util.Date;

public class AdminUserDTO {
	
	private String email;
	private String name;
	private Date birthdate;
	public AdminUserDTO(String email, String name, Date birthdate) {
		super();
		this.email = email;
		this.name = name;
		this.birthdate = birthdate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	

}
