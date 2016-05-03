package baako.server.assemblers;

import baako.server.database.Game;
import baako.server.database.PlainUser;
import baako.server.dto.GameDTO;
import baako.server.dto.PlainUserDTO;

public class GameAssembler {
	
	public static GameAssembler instance;
	public static GameAssembler getInstance(){
		if(instance== null){
			instance = new GameAssembler();	
		}
		return instance;
	}
	

	public GameDTO assemble(Game game) {
		return new GameDTO(game);
	}
	
	public Game disassemble(GameDTO game) {
		return new Game(game);
		
	}
	
	public PlainUserDTO assemble(PlainUser u){
		return new PlainUserDTO(u);
	}
	
	public PlainUser dissasemble(PlainUserDTO u){
		return new PlainUser(u);
	}
	
}
