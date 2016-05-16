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

	/**  Returns the card number of the class Wallet
	 * @return the cardNumb An Integer with the card number
	 */
	public int getCardNumb() {
		return cardNumb;
	}

	/** Returns the CardType of the class Wallet
	 * @return the type A CardType with the card type
	 */
	public CardType getType() {
		return type;
	}
	
}
