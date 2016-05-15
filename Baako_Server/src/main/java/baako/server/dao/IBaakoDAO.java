/**
 * 
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
 * @author Baako-Team
 *
 */
public interface IBaakoDAO {
	
		/** Retrieves a user from the database, given a username
		 * @param username The username of the User to retrieve
		 * @return User retrieved from the database
		 */
		public User getUser(String username);
		/**
		 * @param user
		 */
		public void addUser(PlainUser user);
		/**
		 * @param user
		 */
		public void deleteUser(String user);
		/**
		 * @param game
		 */
		public void addGame(Game game);
		/**
		 * @param game
		 */
		public void deleteGame(String game);
		/**
		 * @param wallet
		 * @param u
		 */
		public void addWallet(Wallet wallet, PlainUser u);
		/**
		 * @param u2
		 * @param u
		 */
		public void addFriend(PlainUser u2, PlainUser u);		
		/**
		 * @param n
		 */
		public void addNews(News n);
		/**
		 * @return
		 */
		public ArrayList<Game> getAllGames();
		/**
		 * @return
		 */
		public ArrayList<Category> getAllCategories();
		/**
		 * @return
		 */
		public ArrayList<Designer> getAllDesigners();
		/**
		 * @param game
		 * @param user
		 */
		public void buyGame(Game game, PlainUser user);
		/**
		 * @param name
		 * @return
		 */
		public Game searchGame(String name);
		/**
		 * @param category
		 * @return
		 */
		public ArrayList<Game> searchGamesByCategory(String category);
		/**
		 * @param designer
		 * @return
		 */
		public ArrayList<Game> searchGamesByDesigner(String designer);		
}