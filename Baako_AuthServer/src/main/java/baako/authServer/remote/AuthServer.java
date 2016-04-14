package baako.authserver.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 * @author Gusy
 *
 */
public class AuthServer extends UnicastRemoteObject implements IAuthServer{


	private static final long serialVersionUID = 7355838780317203327L;
	public HashMap<String, String> users = new HashMap<>();

	public AuthServer() throws RemoteException{
		super();
	}

	@Override
	public boolean checkUserInfo(String username, String password) throws RemoteException {
		if(users.get(username)==null || users.get(password)==null){
			System.out.println("Error in the login");
			return false;
		}
		else if(users.get(username).equals(password)){
			System.out.println("Username: "+username);
			System.out.println("Password: "+password);
			return true;			
		}
		else{
			System.out.println("Error in the login");
			return false;
		}
	}

	@Override
	public boolean register(String username, String password) throws RemoteException {
		if(!users.containsValue(username)){
			users.put(username, password);
			return true;
		}
		else{
			return false;
		}
	}


}
