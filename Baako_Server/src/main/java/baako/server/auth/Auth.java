package baako.server.auth;

import java.rmi.RemoteException;

import baako.server.dao.BaakoDAO;
import baako.server.dao.IBaakoDAO;
import baako.server.database.PlainUser;
import baako.server.database.User;
import baako.server.dto.PlainUserDTO;

/**
 * @author Gusy
 *
 */
public class Auth {

	private BaakoDAO dao;


	public Auth(IBaakoDAO dao) throws RemoteException{
		super();
		this.dao = (BaakoDAO) dao;
	}

	public PlainUserDTO checkUserInfo(String username, String password) throws RemoteException {
//		System.out.println(username);
//		System.out.println(password);
		PlainUser u = (PlainUser) dao.getUser(username);
//		System.out.println(u.getName()+" is trying to log in");
//		System.out.println(u.getPassword());
		if(u.getPassword().equals(password)){
//			System.out.println("Logged as "+ u.getName());
			PlainUserDTO user = new PlainUserDTO(u);
//			System.out.println(user);
			return user;
		}else{
			System.out.println("Error in the login");
			return null;
		}
	}

	public boolean register(PlainUser user) throws RemoteException {
		System.out.println(user);
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
