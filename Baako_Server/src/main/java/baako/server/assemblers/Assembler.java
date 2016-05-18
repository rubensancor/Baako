/** @package baako.server.assemblers
 * 	@brief Package containing assembler classes that allows to do transformations from regular objects to DTOs and viceversa.
 * 
 * <p>This classes are Singletons.</p>
 * <p>Calling one of the methods of assemble() will return that object as DTO in order to make them Serializable.
 * In the same way, calling one of the disassemble() methods, will return a normal object.</p>
 * 
 */

package baako.server.assemblers;

import baako.server.database.Game;
import baako.server.database.News;
import baako.server.database.PlainUser;
import baako.server.dto.GameDTO;
import baako.server.dto.NewsDTO;
import baako.server.dto.PlainUserDTO;

/**
 * @brief Assembler that allows you to do transformations to
 *        {@link Game} and
 *        {@link PlainUser}
 * @author Baako-Team
 *
 */
public class Assembler {

	/**
	 * The Assembler unique instance.
	 * 
	 */
	private static Assembler instance;

	/**
	 * The method to retrieve the instance. It initializes the instance variable
	 * if it is the first time its called.
	 * 
	 * @return The instance of the Assembler.
	 */
	public static Assembler getInstance() {
		if (instance == null) {
			instance = new Assembler();
		}
		return instance;
	}

	/**
	 * Method for assembling games
	 * 
	 * @param game
	 *            The Game you want to assemble in order to make it Serializable
	 * @return The DTO version of the Game given
	 */
	public GameDTO assemble(Game game) {
		return new GameDTO(game);
	}

	/**
	 * Method for disassembling games
	 * 
	 * @param game
	 *            The GameDTO you want to disassemble
	 * @return The normal version of the GameDTO given
	 */
	public Game disassemble(GameDTO game) {
		return new Game(game);
	}

	/**
	 * Method for assembling plain users
	 * 
	 * @param u
	 *            The PlainUser you want to assemble in order to make it
	 *            Serializable
	 * @return The DTO version of the PlainUser given
	 */
	public PlainUser disassemble(PlainUserDTO u) {
		return new PlainUser(u);
	}

	/**
	 * Method for disassembling plain users
	 * 
	 * @param u
	 *            The PlainUserDTO you want to disassemble
	 * @return The normal version of the PlainUserDTO given
	 */
	public PlainUserDTO assemble(PlainUser u) {
		return new PlainUserDTO(u);
	}
		
	public News assemble(NewsDTO n){
		return new News(n);
	}
	
	public NewsDTO disassemble(News n){
		return new NewsDTO(n);
	}
	
}
