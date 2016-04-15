/**
 * 
 */
package baako.server.database;

import javax.jdo.annotations.Element;

/**
 * @author gusy
 *
 */
public class Wallet {

	private int walletId;
	
	private int cardNumb;
	private CardType type;
	
	@Element(column="USER_ID")
	private User user;
}
