package baako.server;

import static org.junit.Assert.assertEquals; 

import org.junit.Before;
import org.junit.Test;

import baako.server.assemblers.GameAssembler;
import baako.server.database.Game;
import baako.server.dto.GameDTO;

/**
 * Unit test for simple App.
 */
public class AssemblerTest {
	
	private Game game;
	private GameDTO dto;
	
	@Before 
    public void setUp() throws Exception { 
        game = new Game("El juego", 20, "Mejor juego del mundo", 18);
        dto = new GameDTO("El juego", 20, "Mejor juego del mundo", 18);
    } 
    @Test 
    public void testAssemble() { 
        assertEquals(dto, GameAssembler.getInstance().assemble(game));
    } 
    @Test 
    public void testDisassemble() { 
        assertEquals(game, GameAssembler.getInstance().disassemble(dto));
    } 
 
}
