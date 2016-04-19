package baako.server.assemblers;

import java.util.Date;
import java.util.Set;

import baako.server.database.Game;
import baako.server.database.PlainUser;
import baako.server.dto.GameDTO;
import baako.server.dto.PlainUserDTO;

public class PlainUserAssambler {

	public static PlainUserAssambler instance;
	public static PlainUserAssambler getInstance(){
		if(instance== null){
			instance = new PlainUserAssambler();	
		}
		return instance;
	}
	
//	public PlainUserDTO getGameDTO(PlainUser plainUser){
//		PlainUserDTO dto= new PlainUserDTO(plainUser.getEmail(),plainUser.getName(),null, plainUser.getFriends());
//		return dto;
//	}
	
	/*
	 * 
	 * 	private String email;
	private String name;
	private Date birthdate;
	private Set<PlainUser> friends;
	 */
	
	
	
}
