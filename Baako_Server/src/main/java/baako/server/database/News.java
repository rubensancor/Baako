/**
 * 
 */
package baako.server.database;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

/**
 * @author Baako-Team
 *
 */
@PersistenceCapable(detachable="true")
@PrimaryKey(name="NEWS_ID")
public class News {

	private String headline;
	
	private Date date;
	private String description;
	
	/**
	 * The constructor of the class
	 * @param headline	The headline of the new
	 * @param date		The date of the new
	 * @param description The description of the new
	 */
	public News(String headline, Date  date, String description){
		this.headline = headline;
		this.date = date;
		this.description = description;
				
	}
	/**
	 * @return the headline
	 */
	public String getHeadline() {
		return headline;
	}
	/**
	 * @param headline the headline to set
	 */
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
