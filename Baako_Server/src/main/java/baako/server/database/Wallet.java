/**
 * 
 */
package baako.server.database;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

/**
 * @brief Class that creates wallets for paying
 * @author Baako-Team
 *
 */
@PersistenceCapable(detachable="true")
public class Wallet {
	@PrimaryKey
	private int cardNumb;
	
	private CardType type;

	/**
	 * Constructor of the class with all the parameters
	 * @param cardNumb The number of the card
	 * @param type The type of the card. The types are listed in {@link CardType}
	 */
	public Wallet(int cardNumb, CardType type) {
		this.cardNumb = cardNumb;
		this.type = type;
	}
	
	/** Constructor for Wallet class. The {@link CardType} is automatically asigned to 'MasterCard'
	 * @param cardNumber An Integer with the card number
	 * 
	 */
	public Wallet(int cardNumber) {
		this.cardNumb = cardNumber;
		this.type = CardType.MASTERCARD;
	}

	/** 
	 * Method that returns the number of the card
	 * @return the number of the card
	 */
	public int getCardNumb() {
		return cardNumb;
	}

	/**
	 * Method that returns the type of the card
	 * @return the type of the card
	 */
	public CardType getType() {
		return type;
	}
	
}
