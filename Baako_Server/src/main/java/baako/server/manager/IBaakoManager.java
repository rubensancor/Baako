/**
 * 
 */
package baako.server.manager;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import baako.server.dto.GameDTO;
import baako.server.dto.PlainUserDTO;

/**
 * @author Baako-Team
 *
 */
public interface IBaakoManager extends Remote{

	/** Check the user information
	 * @param username A String with the username of the User to retrieve
	 * @param password A String with the password of the User to retrieve
	 * @return A PlainUserDTO with the data of the user retrieved
	 * @throws RemoteException
	 */
	public PlainUserDTO checkUserInfo(String username, String password) throws RemoteException;
	
	/** Register the user
	 * @param user A PlainUserDTO to register
	 * @return A boolean. True if the user is registered and false if not.
	 * @throws RemoteException
	 */
	public boolean register(PlainUserDTO user)throws RemoteException;
	
	/** 
	 * @param g A GameDTO which has been bought by a User
	 * @param u The PlainUserDTO who 
	 * @return 
	 * @throws RemoteException
	 */
	public boolean buyGame(GameDTO g, PlainUserDTO u) throws RemoteException;
	
	/** Launch a game 
	 * @return A boolean. True if the game is launched and false if not.
	 * @throws RemoteException
	 */
	public boolean launchGame() throws RemoteException;
	
	/**
	 * @param name
	 * @return
	 * @throws RemoteException
	 */
	public GameDTO searchGame(String name) throws RemoteException;
	
	/**
	 * @param category
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<GameDTO> searchGamebyCategory(String category) throws RemoteException;
	
	/**
	 * @param designer
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<GameDTO> searchGamebyDesigner(String designer) throws RemoteException;
	
	/** Add a Wallet to the database
	 * @param cardNumber An integer with the card number.
	 * @param u A PlainUserDTO  with the data of the User who owns the Wallet
	 * @return A boolean. True if the wallet is added, false if not
	 * @throws RemoteException
	 */
	public boolean addWallet(int cardNumber, PlainUserDTO u) throws RemoteException;
	
	/** Add a Game to the database
	 * @param g A GameDTO to add to the database
	 * @return A boolean. True if the game is added and false if not.
	 * @throws RemoteException
	 */
	public boolean addGame(GameDTO g) throws RemoteException;
	
	/** Returns all the Category from the database
	 * @return All the categories from the DB An ArrayList with all the Category from the database
	 * @throws RemoteException
	 */
	public ArrayList<String> getAllCategories() throws RemoteException;
	
	/** Returns all the Designer from the database
	 * @return All the Designers from the DB An ArrayList with all the Designers from the database
	 * @throws RemoteException
	 */
	public ArrayList<String> getAllDesigners() throws RemoteException;
	/*TODO: 

	public boolean addFriend(PlainUserDTO user, PlainUserDTO newFriend) throws RemoteException;

	public ArrayList<News> getAllNews() throws RemoteException;

	 */
}
