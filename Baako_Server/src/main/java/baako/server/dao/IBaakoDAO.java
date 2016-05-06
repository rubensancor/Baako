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
		public void addGame(Game game);
		public void deleteGame(String game);
		public void addWallet(Wallet wallet);
		public ArrayList<Game> getAllGames();
		public ArrayList<Category> getAllCategories();
		public ArrayList<Designer> getAllDesigners();}
