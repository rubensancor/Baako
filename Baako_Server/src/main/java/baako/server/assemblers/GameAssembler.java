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
	
	public GameDTO getGameDTO(Game game){
		GameDTO dto= new GameDTO(game.getName(),game.getPrice(),game.getDescription(),game.getPEGI());
		return dto;
	}

	
}
