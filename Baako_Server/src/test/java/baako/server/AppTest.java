package baako.server;

import java.util.List;

import baako.server.dao.BaakoDAO;
import baako.server.dao.IBaakoDAO;
import baako.server.database.Game;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
      IBaakoDAO  dao = new BaakoDAO();
		//Add a user
//		PlainUser u = new PlainUser("gvirum@gmail.com","virum","asd",new Date(95,9, 03));
//		System.out.println(u.getEmail());
//		dao.addUser(u);
		
        //Add a game
//		Game game = new Game("Through the Doors", 15, "FPS", 13);
//		System.out.println(game.getName());
//		dao.addGame(game);
		
        //Delete a game
//		dao.deleteGame("kdk");
        //Retrieve all games
        List<Game> games = dao.getAllGames();
        for (Game game : games) {
			System.out.println(game.getDescription());
		}
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
