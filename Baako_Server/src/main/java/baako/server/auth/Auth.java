/** @package baako.server.auth
 * 	@brief Package containing the classes with the logic related to the authorization.
 * 
 */
package baako.server.auth;

import baako.server.assemblers.Assembler;
import baako.server.dao.BaakoDAO;
import baako.server.dao.IBaakoDAO;
import baako.server.database.PlainUser;
import baako.server.database.User;
import baako.server.dto.PlainUserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
/**
<<<<<<< HEAD
 * @brief Class that hosts the logic for the register and the login functions
 * @author BaakoTeam
=======
 * @author Baako-Team
>>>>>>> refs/remotes/origin/master
 *
 */
public class Auth {

	/**
	 * Attribute for logging purpouses
	 */
	Logger logger = LoggerFactory.getLogger(Auth.class);
	
	private BaakoDAO dao;

	/** Constructor of the class
	 * 
	 * @param dao Attribute for accesing to the database
	 */
	public Auth(IBaakoDAO dao){
		super();
		this.dao = (BaakoDAO) dao;
	}

	/** Method that checks if the user and the password match
	 * @param username The username of the {@link User} that wants to log in
	 * @param password The password of the {@link User} that wants to log in
	 * @return 	<p>{@link User} - if the username and the password match</p>
	 * 			<p> null - if it does not match</p>
	 */
	public PlainUserDTO checkUserInfo(String username, String password) {
		//		logger.info(username);
		//		logger.info(password);
		PlainUser u = new PlainUser(dao.getUser(username));
		logger.info("Password: "+u.getPassword());
		if(u.getPassword().equals(password)){
			//			logger.info("Logged as "+ u.getName());
			PlainUserDTO user = Assembler.getInstance().disassemble(u);
			//			logger.info(user);
			return user;

		}else return null;
	}

	/** <p>Method that registers a user</p>
	 * 	<p>It checks if there is already a user with that name, if not it is registered.
	 * @param user {@link PlainUser} that wants to be registered
	 * @return	<p>true - If it is registered</p>
	 * 			<p>false - If it is not registered</p>
	 */
	public boolean register(PlainUser user) {
		logger.info("Registering "+user);
		User u = dao.getUser(user.getName());
		if(u == null){
			dao.addUser(user);
			return true;
		}
		else{
			return false;
		}
	}
}
