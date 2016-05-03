package baako.server.auth;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

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
		//		if(users.get(username)==null || users.get(password)==null){
		//			System.out.println("Error in the login");
		//			return false;
		//		}
		//		else if(users.get(username).equals(password)){
		//			System.out.println("Username: "+username);
		//			System.out.println("Password: "+password);
		//			return true;			
		//		}
		//		else{
		//			System.out.println("Error in the login");
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
