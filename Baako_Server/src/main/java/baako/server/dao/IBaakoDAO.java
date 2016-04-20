/**
 * 
 */
package baako.server.dao;

import baako.server.database.Game;
import baako.server.database.PlainUser;
import baako.server.database.User;

/**
 * @author gusy
 *
 */
public interface IBaakoDAO {

		public User getUser(String username);
		public void addUser(PlainUser user);
		public void addGame(Game game);
		public void deleteGame(String game);
}
