package baako.server.assemblers;

import baako.server.database.AdminUser;
import baako.server.dto.AdminUserDTO;

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
