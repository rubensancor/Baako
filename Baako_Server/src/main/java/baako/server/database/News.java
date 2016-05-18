/**
 * 
 */
package baako.server.database;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import baako.server.dto.NewsDTO;

/**
 * @brief The News class
 * @author Baako-Team
 *
 */
@PersistenceCapable(detachable="true")
@PrimaryKey(name="NEWS_ID")
public class News {

	private String title;

	private Date date;
	private String body;

	/**
	 * The constructor of the class
	 * @param title	The title of the new
	 * @param date		The date of the new
	 * @param description The description of the new
	 */
	public News(String title, Date  date, String body){
		this.title = title;
		this.date = date;
		this.body = body;

	}

	public News(NewsDTO n){
		this.title = n.getTitle();
		this.body = n.getBody();
		this.date = n.getDate();
	}
	/**
	 * @return the headline
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param headline the headline to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	public String getBody() {
		return body;
	}
	/**
	 * @param description the description to set
	 */
	public void setBody(String body) {
		this.body = body;
	}
}
