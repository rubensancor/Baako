package baako.server.assemblers;

import java.util.Date;

import baako.server.database.AdminUser;
import baako.server.database.PlainUser;
import baako.server.dto.AdminUserDTO;
import baako.server.dto.PlainUserDTO;

public class AdminUserAssambler {

	public static AdminUserAssambler instance;
	public static AdminUserAssambler getInstance(){
		if(instance== null){
			instance = new AdminUserAssambler();	
		}
		return instance;
	}

	public AdminUserDTO getAdminUserDTO(AdminUser adminUser){
		AdminUserDTO dto= new AdminUserDTO(adminUser.getEmail(),adminUser.getName(),adminUser.getBirthdate());
		return dto;
	}
}
