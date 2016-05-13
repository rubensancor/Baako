/**
 * 
 */
package baako.client.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import baako.client.remote.RMIServiceLocator;
import baako.server.dto.GameDTO;
import baako.server.dto.PlainUserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 


/**
 * @author Baako-Team
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

	public String logIn(String username, String password){
		try {
			logger.info("Controller----> ");
			logger.info("Username---> "+username);
			logger.info("Password---> "+password);
			user = rmi.getService().checkUserInfo(username, password);
			logger.info(user.getEmail());
			return user.getName();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean register(PlainUserDTO u){
		try{
			logger.info("Register");
			logger.info("Username---> "+u.getName());
			logger.info("Password---> "+u.getPassword());
			
			if(rmi.getService().register(u)){
				logger.info("PASOTERE");
				return true;
			}else{
				return false;
			}
		}catch(RemoteException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addGame(GameDTO game){
		try{
			logger.info("Adding game");
			logger.info("Name-->"+game.getName());
			logger.info("Price -->"+game.getPrice());
			return rmi.getService().addGame(game);
		}catch(RemoteException e){
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<String> getAllCategories(){
		try {
			return  rmi.getService().getAllCategories();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**  
	 * @return
	 */
	public ArrayList<String> getAllDesigners(){
		try {
			return  rmi.getService().getAllDesigners();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public GameDTO searchGame(String name){
		GameDTO g =null;
		try {
			g = rmi.getService().searchGame(name);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return g;
	}

}
