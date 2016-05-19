package baako.server;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import baako.server.assemblers.Assembler;
import baako.server.database.Game;
import baako.server.database.PlainUser;
import baako.server.dto.GameDTO;
import baako.server.dto.PlainUserDTO;

/**
 * Unit test for simple App.
 */
public class AssemblerTest {
	
	private static Game game;
	private static GameDTO gamedto;
	private static PlainUser u;
	private static PlainUserDTO userdto;
	
	@BeforeClass 
    public static void setUp() throws Exception { 
        game = new Game("El juego", 20, "Mejor juego del mundo",18, "www.google.es");
        gamedto = new GameDTO("El juego", 20, "Mejor juego del mundo", 18);
        u = new PlainUser("gvirum@gmail.com", "Gaizka", "Tere", new Date(System.currentTimeMillis()));
        userdto = new PlainUserDTO("gvirum@gmail.com", "Gaizka", "Tere", new Date(System.currentTimeMillis()));
    } 
    @Test 
    public void testAssembleGame() { 
        assertEquals("El juego", Assembler.getInstance().assemble(game).getName());
    } 
    @Test 
    public void testDisassembleGame() { 
        assertEquals("El juego", Assembler.getInstance().disassemble(gamedto).getName());
    } 
    @Test 
    public void testAssembleUser() { 
        assertEquals("Gaizka", Assembler.getInstance().assemble(u).getUsername());
    } 
    @Test 
    public void testDisassembleUser() { 
        assertEquals("Gaizka", Assembler.getInstance().disassemble(userdto).getName());
    } 
 
}
