package baako.server.dto;

import java.util.Date;
import java.util.Set;

import baako.server.database.PlainUser;

public class PlainUserDTO{
	
	private String email;
	private String name;
	private Date birthdate;
	private Set<PlainUser> friends;

	public PlainUserDTO(String email, String name, Date birthdate, Set<PlainUser> friends) {
		super();
		this.email = email;
		this.name = name;
		this.birthdate = birthdate;
		this.friends = friends;
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
	public Set<PlainUser> getFriends() {
		return friends;
	}
	public void setFriends(Set<PlainUser> friends) {
		this.friends = friends;
	}
}
