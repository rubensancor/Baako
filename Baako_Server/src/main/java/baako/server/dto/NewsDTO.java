/**
 * 
 */
package baako.server.dto;

import java.io.Serializable;
import java.util.Date;

import baako.server.database.News;

/**
 * @author gusy
 *
 */
public class NewsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String body;
	private Date date;
	
	/**
	 * 
	 */
	public NewsDTO(String title, String body, Date date) {
		this.title = title;
		this.body = body;
		this.date = date;
	}
	
	public NewsDTO(News n){
		this.title = n.getTitle();
		this.body = n.getBody();
		this.date = n.getDate();
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@SuppressWarnings("deprecation")
	@Override
	public String toString() {
//		return this.title +" [" ;//*+ this.date.getDay() +"/" + this.date.getMonth() +"/" + this.date.getYear()+"]";*//
			return this.title;
	}
	
	
}
