package baako.server.auth;

import java.rmi.RemoteException;

import baako.server.dao.BaakoDAO;
import baako.server.dao.IBaakoDAO;
import baako.server.database.PlainUser;
import baako.server.database.User;
import baako.server.dto.PlainUserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
/**
 * @author Gusy
 *
 */
public class Auth {

	Logger logger = LoggerFactory.getLogger(Auth.class);
	private BaakoDAO dao;


	public Auth(IBaakoDAO dao) throws RemoteException{
		super();
		this.dao = (BaakoDAO) dao;
	}

	public PlainUserDTO checkUserInfo(String username, String password) throws RemoteException {
//		logger.info(username);
//		logger.info(password);
		PlainUser u = (PlainUser) dao.getUser(username);
//		logger.info(u.getName()+" is trying to log in");
//		logger.info(u.getPassword());
		if(u.getPassword().equals(password)){
//			logger.info("Logged as "+ u.getName());
			PlainUserDTO user = new PlainUserDTO(u);
//			logger.info(user);
			return user;
		}else{
			logger.error("Error in the login");
			return null;
		}
		//		if(users.get(username)==null || users.get(password)==null){
		//			logger.error("Error in the login");
		//			return false;
		//		}
		//		else if(users.get(username).equals(password)){
		//			logger.info("Username: "+username);
		//			logger.info("Password: "+password);
		//			return true;			
		//		}
		//		else{
		//			logger.error("Error in the login");
		//			return false;
		//		}
	}

	public boolean register(PlainUser user) throws RemoteException {
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
