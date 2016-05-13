/**
 * 
 */
package baako.server.database;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

/**
 * @author Baako-Team
 *
 */
@PersistenceCapable(detachable="true")
public class Wallet {
	@PrimaryKey
	private int cardNumb;
	
	
	private CardType type;

	public Wallet(int cardNumb, CardType type) {
		this.cardNumb = cardNumb;
		this.type = type;
	}
	
	/** Constructor for Wallet class
	 * @param cardNumber An Integer with the card number
	 */
	public Wallet(int cardNumber) {
		this.cardNumb = cardNumber;
		this.type = CardType.MASTERCARD;
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
	
}
