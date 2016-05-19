/**
 * 
 */
package baako.client.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import baako.client.remote.RMIServiceLocator;
import baako.server.dto.GameDTO;
import baako.server.dto.NewsDTO;
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

	public PlainUserDTO logIn(String username, String password){
		try {
			logger.info("Controller----> ");
			logger.info("Username---> "+username);
			logger.info("Password---> "+password);
			user = rmi.getService().checkUserInfo(username, password);
			logger.info(user.getEmail());
			return user;
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
			logger.info(game.getCategoriesString().get(0).toString());
			logger.info(game.getDesignersString().get(0).toString());
			
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

	public boolean addNews(NewsDTO n){
		try {
			return rmi.getService().addNews(n);
		} catch(RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<NewsDTO> getAllNews(){
		try{
			return rmi.getService().getAllNews();
		}catch(RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @return
	 */
	public ArrayList<GameDTO> getAllGames() {
		try{
			return rmi.getService().getAllGames();
		}catch(RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean buy(GameDTO game){
		try {
			return rmi.getService().buyGame(game, user);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @return
	 */
	public ArrayList<GameDTO> getUserGames() {
		try{
			return rmi.getService().getUsersGames(user);
		}catch(RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<GameDTO> searchGamesByCategory(String category) throws RemoteException {
		try{
			return rmi.getService().searchGamebyCategory(category);
		}catch(RemoteException e) {
			e.printStackTrace();
			return null;
		}	 
	}
	public ArrayList<GameDTO> searchGamesByDesigner(String designer) throws RemoteException {
		try{
			return rmi.getService().searchGamebyDesigner(designer);
		}catch(RemoteException e) {
			e.printStackTrace();
			return null;
		}	 
	}

	/**
	 * @return
	 */
	public ArrayList<PlainUserDTO> getAllUsers() {
		try {
			return rmi.getService().getAllUsers();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean addFriend(PlainUserDTO newFriend){
		try {
			return rmi.getService().addFriend(user, newFriend);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteFriend(PlainUserDTO oldFriend){
		try {
			return rmi.getService().deleteFriend(user, oldFriend);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param name
	 * @param price
	 * @param text
	 * @param pegi
	 * @param values2
	 * @param values4
	 * @return 
	 */
	public boolean editGame(String name, int price, String text, int pegi, ArrayList<String> values2,
			ArrayList<String> values4) {
		return rmi.getService().editGame(name, price, text, pegi, values2, values4);
	}
	
}
