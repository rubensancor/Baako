package baako.server.auth;

import java.rmi.RemoteException;

import baako.server.assemblers.Assembler;
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
		PlainUser u = new PlainUser(dao.getUser(username));
		logger.info("Password: "+u.getPassword());
		if(u.getPassword().equals(password)){
			//			logger.info("Logged as "+ u.getName());
			PlainUserDTO user = Assembler.getInstance().assemble(u);
			//			logger.info(user);
			return user;

		}else return null;
	}

	public boolean register(PlainUser user) throws RemoteException {
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
