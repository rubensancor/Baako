/**
 * 
 */
package baako.client.controller;

import java.rmi.RemoteException;

import baako.client.remote.RMIServiceLocator;
import baako.server.dto.PlainUserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 


/**
 * @author gusy
 *
 */
public class BaakoController {
	
	Logger logger = LoggerFactory.getLogger(BaakoController.class);
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
			logger.info("Controller----> ");
			logger.info("Username---> "+username);
			logger.info("Password---> "+password);
			user = rmi.getService().checkUserInfo(username, password);
			logger.info(user.getEmail());
			return user != null;
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean register(PlainUserDTO u){
		try{
			logger.info("Register");
			logger.info("Username---> "+u.getName());
			logger.info("Password---> "+u.getPassword());
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
