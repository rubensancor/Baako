/**
 * 
 */
package baako.server.database;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

/**
 * @author gusy
 *
 */
@PersistenceCapable
public class Wallet {
	@PrimaryKey
	private int cardNumb;
	
	private CardType type;
	
	@Element(column="USER_ID")
	private User user;

	public Wallet(int cardNumb, CardType type, User user) {
		this.cardNumb = cardNumb;
		this.type = type;
		this.user = user;
	}
	
	/**
	 * @return the cardNumb
	 */
	public int getCardNumb() {
		return cardNumb;
	}

	/**
	 * @return the type
	 */
	public CardType getType() {
		return type;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	
	
	
}
