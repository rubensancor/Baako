/**
 * 
 */
package baako.client.controller;

import java.rmi.RemoteException;

import baako.client.remote.RMIServiceLocator;
import baako.server.database.PlainUser;
import baako.server.dto.PlainUserDTO;
import baako.server.dto.UserDTO;

/**
 * @author gusy
 *
 */
public class BaakoController {
	
	private RMIServiceLocator rmi;
	private static PlainUserDTO user;
	 
	/**
	 * 
	 */
	public BaakoController(RMIServiceLocator rmi) {
		this.rmi = rmi;
	}
	
	public boolean logIn(String username, String password){
		try {
			System.out.println("Controller----> ");
			System.out.println("Username---> "+username);
			System.out.println("Password---> "+password);
			user = rmi.getService().checkUserInfo(username, password);
			if(user.getPassword().equals(password)){
				return true;
			}
			else{
				return false;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean register(PlainUser u){
		try{
			System.out.println("Register");
			System.out.println("Username---> "+u.getName());
			System.out.println("Password---> "+u.getPassword());
			if(rmi.getService().register(u)){
				return true;
			}else{
				return false;
			}
		}catch(RemoteException e){
			e.printStackTrace();
			return false;
		}
	}
}
