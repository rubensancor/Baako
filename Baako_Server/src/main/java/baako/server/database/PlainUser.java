package baako.server.database;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import baako.server.assemblers.Assembler;
import baako.server.dto.GameDTO;
import baako.server.dto.PlainUserDTO;

/**
 * @brief The main users of the Baako App
 * 
 * This are the main users of the baako app, the ones who can play games, browse news and access to all the functionalities that Baako provides.
 * They don't have any administration power
 * 
 * @author Baako-Team
 *
 */
@PersistenceCapable(detachable="true")
public class PlainUser extends User {


	@Persistent(table="PLAINUSER_FRIEND", defaultFetchGroup="true")
	@Join(column="PLAINUSER_ID_A")
	@Element(column="PLAINUSER_ID_B")
	private Set<PlainUser> friends;

	@Persistent(table="PLAINUSER_GAMES", defaultFetchGroup="true")
	@Join(column="PLAINUSER_ID")
	@Element(column="GAME_ID")
	private Set<Game> games;

	@Column(name="WALLET_ID")
	private Wallet wallet;
	
	/** Contructor of a PlainUser with all the attributes
	 * @param email A String with the email of the user
	 * @param name A String with the of the user
	 * @param password A String with the password of the user
	 * @param birthdate A Date with the birthdate of the user
	 * @param friends A Set of PlainUser containing the friends of the user
	 * @param games A Set of Game containing the games owned by the user
	 * @param wallet The Wallet of the user
	 */
	public PlainUser(String email, String name, String password, Date birthdate, Set<PlainUser> friends, Set<Game> games, Wallet wallet) {
		super(email, name, password, birthdate);
		this.friends = friends;
		this.games = games;
		this.wallet = wallet;
	}

	/**
	 * Constructor with some of the parameters, it is created with no friends nor games and with no wallet
	 * @param email The email of the user
	 * @param name	The name of the user
	 * @param password	The password of the user
	 * @param birthdate	The birthdate of the user
	 */
	public PlainUser(String email, String name, String password, Date birthdate) {
		super(email, name, password, birthdate);
		this.friends = new HashSet<PlainUser>();
		this.games = new HashSet<Game>();
		this.wallet = null;
	}
	/**
	 * Constructor that allows to create a new user from a {@link PlainUserDTO} given
	 * @param user The {@link PlainUserDTO} given
	 */
	public PlainUser(PlainUserDTO u) {
		super(u.getEmail(), u.getName(), u.getPassword(), u.getBirthdate());
		for (PlainUserDTO friend : u.getFriends()) {
			this.friends.add(Assembler.getInstance().disassemble(friend));
		}
		for (GameDTO game: u.getGames()) {
			this.games.add(Assembler.getInstance().disassemble(game));
		}
	}

	/**
	 * Constructor that allows to create a new user from a {@link PlainUser} given
	 * @param user The {@link PlainUser} given
	 */
	public PlainUser(PlainUser u){
		super(u.getEmail(), u.getName(), u.getPassword(), u.getBirthdate());
		this.friends = u.getFriends();
		this.games = u.getGames();	
	}

	/**
	 * Method that adds a game to the user
	 * @param g the game to add
	 */
	public void addGame(Game g){
		if(!games.contains(g))
		this.games.add(g);
	}

	/**
	 * Method that adds a friend to the user
	 * @param u
	 */
	public void addFriend(PlainUser u){
		friends.add(u);
	}


	/**
	 * @return the games
	 */
	public Set<Game> getGames() {
		return games;
	}

	/**
	 * @param games the games to set
	 */
	public void setGames(Set<Game> games) {
		this.games = games;
	}

	/**
	 * @return the wallet
	 */
	public Wallet getWallet() {
		return wallet;
	}

	/**
	 * @param wallet the wallet to set
	 */
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	/**
	 * @param friends the friends to set
	 */
	public void setFriends(Set<PlainUser> friends) {
		this.friends = friends;
	}

	/**
	 * @return the friends
	 */
	public Set<PlainUser> getFriends() {
		return friends;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User: "+username;
	}
	
	
	/**
	 * Method that allows the user to pay
	 * @param money The amout of money to pay
	 * @return
	 * 		<p>true - If the payment is done correctly</p>
	 * 		<p>false - If it isn't</p>
	 */
	public boolean pay(float money){
		// OMG CRAZY ASF PAYING STUFF
		return true;
	}


}
