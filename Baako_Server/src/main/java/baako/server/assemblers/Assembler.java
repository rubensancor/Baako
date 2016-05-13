package baako.server.assemblers;

import baako.server.database.Game;
import baako.server.database.PlainUser;
import baako.server.dto.GameDTO;
import baako.server.dto.PlainUserDTO;
/**
 * @author Baako-Team
 *
 */
public class Assembler {
	
	private static Assembler instance;
	public static Assembler getInstance(){
		if(instance== null){
			instance = new Assembler();	
		}
		return instance;
	}
	

	public GameDTO assemble(Game game) {
		return new GameDTO(game);
	}
	
	public Game disassemble(GameDTO game) {
		return new Game(game);
		
	}
	
	public PlainUserDTO disassemble(PlainUser u){
		return new PlainUserDTO(u);
	}
	
	public PlainUser assemble(PlainUserDTO u){
		return new PlainUser(u);
	}
	
}
