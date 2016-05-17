/** @package baako.server.manager
 * @brief Package containing the manager interface of the server which allows the client to access to the server zone.
 */
package baako.server.manager;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;

import baako.server.database.News;
import baako.server.dto.GameDTO;
import baako.server.dto.NewsDTO;
import baako.server.dto.PlainUserDTO;
import baako.server.dto.UserDTO;

/**
 * @brief Interface with all the methods that the Client is able to use
 * @author Baako-Team
 */
public interface IBaakoManager extends Remote{

	/** Check the user information
	 * @param username A String with the username of the {@link User} to retrieve
	 * @param password A String with the password of the {@link User} to retrieve
	 * @return A {@link PlainUserDTO} with the data of the {@link User} retrieved
	 * @throws RemoteException
	 */
	public PlainUserDTO checkUserInfo(String username, String password) throws RemoteException;
	
	/** Register the user
	 * @param user A {@link PlainUserDTO} to register
	 * @return A boolean. True if the user is registered and false if not.
	 * @throws RemoteException
	 */
	public boolean register(PlainUserDTO user)throws RemoteException;
	
	/**  Buy a Game by a User
	 * @param g A {@link GameDTO} which has been bought by a {@link User}
	 * @param u The {@link PlainUserDTO} who bought the {@link Game}
	 * @return  A boolean. True if the game is bought successfully, false if not
	 * @throws RemoteException
	 */
	public boolean buyGame(GameDTO g, PlainUserDTO u) throws RemoteException;
	
	/** Launch a game 
	 * @return A boolean. True if the {@link Game} is launched and false if not.
	 * @throws RemoteException
	 */
	public boolean launchGame() throws RemoteException;
	
	/** Search a {@link Game}
	 * @param name A String with the name of the {@link Game}
	 * @return A {@link GameDTO } with the data of the {@link Game} retrieved
	 * @throws RemoteException
	 */
	public GameDTO searchGame(String name) throws RemoteException;
	
	/** Search all the {@link Game} given a {@link Category}
	 * @param category A String with the name of the {@link Category}
	 * @return An ArrayList of {@link Game} with all the games in the {@link Category}
	 * @throws RemoteException
	 */
	public ArrayList<GameDTO> searchGamebyCategory(String category) throws RemoteException;
	
	/** Search all the {@link Game} given a {@link Designer}
	 * @param designer A String with the name of the {@link Designer}
	 * @return An ArrayList of {@link Game} with all the games in the {@link Designer}
	 * @throws RemoteException
	 */
	public ArrayList<GameDTO> searchGamebyDesigner(String designer) throws RemoteException;
	
	/** Add a {@link Wallet} to the database
	 * @param cardNumber An integer with the card number.
	 * @param u A PlainUserDTO  with the data of the User who owns the Wallet
	 * @return A boolean. True if the wallet is added, false if not
	 * @throws RemoteException
	 */
	public boolean addWallet(int cardNumber, PlainUserDTO u) throws RemoteException;
	
	/** Add a Game to the database
	 * @param g A {@link GameDTO} to add to the database
	 * @return A boolean. True if the game is added and false if not.
	 * @throws RemoteException
	 */
	public boolean addGame(GameDTO g) throws RemoteException;
	
	/** Returns all the Category from the database
	 * @return An ArrayList of {@link Category} with all the categories from the database
	 * @throws RemoteException
	 */
	public ArrayList<String> getAllCategories() throws RemoteException;
	
	/** Returns all the designers from the database
	 * @return  An ArrayList of {@link Designer} with all the designers from the database
	 * @throws RemoteException
	 */
	public ArrayList<String> getAllDesigners() throws RemoteException;
	
	/** Adds a piece of News to the database
	 * @param n A {@link NewsDTO} with the data of the {@link News} to add to the database
	 * @return
	 * @throws RemoteException
	 */
	public boolean addNews(NewsDTO n) throws RemoteException;
	
	/**
	 * Retrieves all the games of the user
	 * @param user The user that wants to retrieve the games
	 * @return An Arraylist of games
	 * @throws RemoteException
	 */
	public ArrayList<GameDTO> getUsersGames(PlainUserDTO user) throws RemoteException;
	
	/**
	 * Retrieves the latest news
	 * @return The latest news
	 * @throws RemoteException
	 */
	public ArrayList<News> getAllNews() throws RemoteException;
	/*TODO: 

	public boolean addFriend(PlainUserDTO user, PlainUserDTO newFriend) throws RemoteException;


	 */
}
