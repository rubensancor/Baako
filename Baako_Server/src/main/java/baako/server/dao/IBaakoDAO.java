/**
 * 
 */
package baako.server.dao;

import java.util.ArrayList;
import baako.server.database.Category;
import baako.server.database.Designer;
import baako.server.database.Game;
import baako.server.database.PlainUser;
import baako.server.database.User;
import baako.server.database.Wallet;

/**
 * @author gusy
 *
 */
public interface IBaakoDAO {

		public User getUser(String username);
		public void addUser(PlainUser user);
		public void deleteUser(String user);
		public void addGame(Game game);
		public void deleteGame(String game);
		public void addWallet(Wallet wallet, PlainUser u);
		public ArrayList<Game> getAllGames();
		public ArrayList<Category> getAllCategories();
		public ArrayList<Designer> getAllDesigners();
		public void buyGame(Game game, PlainUser user);
		public Game searchGame(String name);
		public ArrayList<Game> searchGamesByCategory(String category);
		public ArrayList<Game> searchGamesByDesigner(String designer);		
}