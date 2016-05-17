/** @package baako.server.dao
 *  @brief Package containing the classes and the interfaces that sends SQL queries to the database
 */
package baako.server.dao;

import java.util.ArrayList;
import baako.server.database.Category;
import baako.server.database.Designer;
import baako.server.database.Game;
import baako.server.database.News;
import baako.server.database.PlainUser;
import baako.server.database.User;
import baako.server.database.Wallet;

/**
 * @brief Interface with all the methods that make changes in the database.
 * @author Baako-Team
 */
public interface IBaakoDAO {
	
		
	/** Retrieves a user from the database, given a username
		 * @param username The username of the {@link User}  to retrieve
		 * @return {@link User} retrieved from the database
		 */
		public User getUser(String username);
		
		/** Adds a {@link User} to the database
		 * @param user The {@link User} to be added
		 */
		public void addUser(PlainUser user);
		
		/** Deletes an user from the database 
		 * @param user A String with the username of the {@link User} to be deleted
		 */
		public void deleteUser(String user);
		
		/**Adds a Game to the database
		 * @param game The {@link Game} to be added
		 */
		public void addGame(Game game);
		
		/** Deletes a Game from the database
		 * @param game A String with the name of the {@link Game} to be deleted
		 */
		public void deleteGame(String game);
		
		/** Creates the link between Wallet and User in the database
		 * @param wallet A {@link Wallet} to be attached to the user
		 * @param u A {@link User} with the propietary of the {@link Wallet}
		 */
		public void addWallet(Wallet wallet, PlainUser u);
		
		/** Creates the link between two Users in the database
		 * @param u A {@link User} to be linked
		 * @param u2 A {@link User} to be linked
		 */
		public void addFriend(PlainUser u, PlainUser u2);		
		
		/** Creates the link between a User and a Game
		 * @param game The {@link Game} to be linked with the User
		 * @param user The {@link User} who bought the Game
		 */
		public void buyGame(Game game, PlainUser user);
		
		/** Adds a News to the database
		 * @param n The {@link News} to be added
		 */
		public void addNews(News n);
		
		/** Retrieves all the Game in the database
		 * @return An ArrayLIst of {@link Game} with all the games
		 */
		public ArrayList<Game> getAllGames();
		
		/** Retrieves all the Category in the database
		 * @return An ArrayList of {@link Category} with all the categories
		 */
		public ArrayList<Category> getAllCategories();
		
		/** Retrieves all the Designer in the database
		 * @return An ArrayList of {@link Designer} with all the designers
		 */
		public ArrayList<Designer> getAllDesigners();
		
		/** Retrieves a Game from the database, given the name
		 * @param name A String with the name of the {@link Game} to retrieve
		 * @return The {@link Game} to retrieve
		 */
		public Game searchGame(String name);
		
		/** Retrieves all the Games in the database, given a Category
		 * @param category A String with the name of the {@link Category}
		 * @return An ArrayList of {@link Game} with the games retrieved
		 */
		public ArrayList<Game> searchGamesByCategory(String category);
		
		/** Retrieves all the Games in the database, given a Designer
		 * @param designer A String with the name of the {@link Designer}
		 * @return An ArrayList of {@link Game} with the games retrieved
		 */
		public ArrayList<Game> searchGamesByDesigner(String designer);		
		
		/** Edit the parameters of a Game
		 * @param game
		 */
		public void editGame(Game game);
}