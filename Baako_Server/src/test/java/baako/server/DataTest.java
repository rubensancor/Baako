package baako.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import baako.client.remote.RMIServiceLocator;
import baako.server.auth.Auth;
import baako.server.dao.IBaakoDAO;
import baako.server.database.CardType;
import baako.server.database.Category;
import baako.server.database.Designer;
import baako.server.database.Game;
import baako.server.database.News;
import baako.server.database.PlainUser;
import baako.server.database.User;
import baako.server.database.Wallet;
import baako.server.dto.GameDTO;
import baako.server.dto.PlainUserDTO;

public class DataTest {
	@Rule
	public ContiPerfRule i = new ContiPerfRule();
	private static Category cat;
	private static Designer desig;
	private static Game game;
	private static PlainUser u;
	private static Wallet wallet;
	private static GameDTO gamedto;
	private static PlainUserDTO userdto;

	@BeforeClass
	public static void setUpClass() throws Exception {
		u = new PlainUser("gvirum@gmail.com", "Gaizka", "asd", new Date());
		wallet = new Wallet(1);
		cat = new Category("Accion");
		desig = new Designer("El numi");
		game = new Game("Juego", 10, "Juego", 18, "www.google.es");
		game = new Game("Game", 18, "Game", 7, "www.google.es");
		userdto = new PlainUserDTO("rubensancor@gmail.com", "Ruben", "asd",
				new Date());

	}

	@Test
	public void testCategory() {
		int before = cat.getNumbGames();
		cat.addGame(game);
		String s = cat.getName();
		assertEquals(before + 1, cat.getNumbGames());
		assertEquals("Accion", s);
	}

	@Test
	public void testDesigner() {
		int before = desig.getNumbGames();
		desig.addGame(game);
		assertEquals(before + 1, desig.getNumbGames());
		assertEquals("El numi", desig.getName());
	}

	// @Test(expected = NullPointerException.class)
	@PerfTest(invocations = 10000, threads = 20)
	@Required(max = 1200, average = 250, throughput = 20)
	public void testGame() {
		Game g = new Game(gamedto);
		assertEquals(g.getName(), gamedto.getName());
		g.setName("Numi");
		g.setDescription("Numi");
		g.setPEGI(8);
		g.setPrice(20);
		assertEquals("Numi", g.getName());
		assertEquals(8, g.getPEGI());
		assertEquals("Numi", g.getDescription());
		assertEquals(20, g.getPEGI());
		assertEquals(null, g.getCategories());
		assertEquals(null, g.getDesigners());
	}

	@Test
	@PerfTest(invocations = 1000, threads = 20)
	@Required(max = 1200, average = 250)
	public void testWallet() {
		assertEquals(1, wallet.getCardNumb());
		assertEquals(CardType.MASTERCARD, wallet.getType());
	}

	@Test
	// @PerfTest(invocations = 1000, threads = 20)
	// @Required(max = 1200, average = 250)
	public void testUser() {
		PlainUser p = new PlainUser(userdto);
		HashSet<Game> games = new HashSet<Game>();
		games.add(new Game("LOL", 0, "MOBA", 10, "www.google.es"));
		HashSet<PlainUser> friends = new HashSet<PlainUser>();
		friends.add(u);
		p.setGames(games);
		p.setFriends(friends);
		p.addGame(game);
		p.addFriend(new PlainUser("txali@gmail.com", "TXAHLI", "ISUCK",
				new Date()));
		assertEquals(2, p.getFriends().size());
		assertEquals(2, p.getGames().size());
	}

	public void testUserDTO() {

	}

	public void testNewsDTO() {

	}

	public void testPlainUserDTO() {

	}
	// @Test
	// public void testAnotherThing() {
	// // Code that tests another thing
	// }
	// @Test
	// public void testSomethingElse() {
	// // Code that tests something else
	// }
	// @After
	// public void tearDown() throws Exception {
	// // Code executed after each test
	// }
	// @AfterClass
	// public static void tearDownClass() throws Exception {
	// // Code executed after the last test method
	// }

}
