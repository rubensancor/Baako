/**
 * 
 */
package baako.server.database;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.PrimaryKey;

/**
 * @author gusy
 *
 */
public class Wallet {
	@PrimaryKey
	private int walletId;
	
	private int cardNumb;
	private CardType type;
	
	@Element(column="USER_ID")
	private User user;

	/**
	 * @return the walletId
	 */
	public int getWalletId() {
		return walletId;
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
