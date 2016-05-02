package baako.server.assemblers;

import baako.server.database.Game;
import baako.server.dto.GameDTO;

public class GameAssembler {
	
	public static GameAssembler instance;
	public static GameAssembler getInstance(){
		if(instance== null){
			instance = new GameAssembler();	
		}
		return instance;
	}
	

	public GameDTO assemble(Game game) {
		GameDTO dto= new GameDTO(game);
		return dto;
	}
	
	public Game disassemble(GameDTO game) {
		Game normal = new Game(game);
		return normal;

	}
	
}
