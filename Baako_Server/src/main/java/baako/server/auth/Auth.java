package baako.server.auth;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import baako.server.dao.BaakoDAO;
import baako.server.dao.IBaakoDAO;
import baako.server.database.PlainUser;
import baako.server.database.User;

/**
 * @author Gusy
 *
 */
public class Auth extends UnicastRemoteObject implements IAuth{

	private BaakoDAO dao;

	private static final long serialVersionUID = 7355838780317203327L;
	public HashMap<String, String> users = new HashMap<String, String>();

	public Auth(IBaakoDAO dao) throws RemoteException{
		super();
		this.dao = (BaakoDAO) dao;
	}

	public boolean checkUserInfo(String username, String password) throws RemoteException {
		System.out.println(username);
		System.out.println(password);
		PlainUser u = (PlainUser) dao.getUser(username);
		System.out.println(u.getName()+" is trying to log in");
		System.out.println(u.getPassword());
		if(u.getPassword().equals(password)){
			System.out.println("Logged as "+ u.getName());
			return true;
		}else{
			System.out.println("Error in the login");
			return false;
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
		}
		//		if(!users.containsValue(username)){
		//			System.out.println("Registrado");
		//			users.put(username, password);
		//			return true;
		//		}
		//		else{
		//			return false;
		//		}
		//	}
		return true;
	}
}
