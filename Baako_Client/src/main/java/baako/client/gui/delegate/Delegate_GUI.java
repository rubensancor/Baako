/**
 * 
 */
package baako.client.gui.delegate;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import baako.client.controller.BaakoController;
import baako.client.gui.GUI;
import baako.server.dto.GameDTO;
import baako.server.dto.NewsDTO;
import baako.server.dto.PlainUserDTO;

/**
 * @author Baako-Team
 *
 */
public class Delegate_GUI extends GUI{

	private BaakoController controller;
	private ArrayList<String> categories = null;
	private ArrayList<String> designers = null;
	private ArrayList<String> admins = new ArrayList<String>();
	private ArrayList<String> categories2 = new ArrayList<String>();
	private ArrayList<String> designers2 = new ArrayList<String>();


	public Delegate_GUI(BaakoController controller){
		this.controller = controller;
		categories = new ArrayList<String>();
		designers = new ArrayList<String>();
		admins.add("gaizka");
		admins.add("carlos");
	}

	/* (non-Javadoc)
	 * @see baako.client.gui.GUI#fill()
	 */
	public void fill(){
		logger.info("FILL");

		//		logger.info(controller.getAllCategories().get(0));
		categories.addAll(controller.getAllCategories());
		for (String string : categories) {
			categoryCBox.addItem(string);
			categoryCBoxOpt1.addItem(string);
			categoryCBoxOpt2.addItem(string);
			categoryCBoxOpt3.addItem(string);
			categoryCBoxOpt4.addItem(string);
			categoryCBoxOpt5.addItem(string);
		}

		//		logger.info(controller.getAllDesigners().get(0));
		designers.addAll(controller.getAllDesigners());
		for (String string : designers) {
			designerCBox.addItem(string);
			designerCBoxOpt1.addItem(string);
			designerCBoxOpt2.addItem(string);
			designerCBoxOpt3.addItem(string);
		}

		logger.info("Out of fill");
	}

	public void fillNews(){
		logger.info("FILLING NEWS");
		news = controller.getAllNews();
	}

	public void fillGames(){
		logger.info("FILLING GAMES");
		games = controller.getAllGames();
	}

	public void fillOwned(){
		logger.info("FILLING Owned");
		owned = controller.getUserGames();
	}

	public void fillPeople(){
		logger.info("FILLING People");
		news = controller.getAllUsers();
	}

	/* (non-Javadoc)
	 * @see baako.client.gui.GUI#logIn(java.lang.String, java.lang.String)
	 */
	public boolean logIn(String username, String password){
		user = controller.logIn(username, password);
		if(user != null){
			if(admins.contains(user.getName())) admin = true; 
			else admin = false;
			return true;
		}else{
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see baako.client.gui.GUI#register(java.lang.String, java.lang.String, java.lang.String, java.util.Date)
	 */
	public boolean  register(String email, String username, String password, Date date){
		logger.info("VAMOS A REGISTRAR");
		PlainUserDTO u = new PlainUserDTO(email, username, password, date, null, null);
		logger.info(u.getEmail());
		controller.register(u);
		return true;
	}

	/* (non-Javadoc)
	 * @see baako.client.gui.GUI#addGame(java.lang.String, int, java.lang.String, int)
	 */
	public boolean addGame(String name, int price, String description, int pegi){
		categories2.add(categoryCBox.getSelectedItem().toString());
		designers2.add(designerCBox.getSelectedItem().toString());
		categoriesToArray();
		designersToArray();
		GameDTO g = new GameDTO(name, price, description, pegi, "www.google.com", categories2, designers2);
		games.add(g);
		return controller.addGame(g);
	}

	public boolean addNews(String title, String body, Date date){
		NewsDTO n = new NewsDTO(title, body, date);
		news.add(n);
		return controller.addNews(n);
	}

	/**
	 * 
	 */
	public void categoriesToArray(){
		if(categoryCBoxOpt1.getSelectedItem()!=null){
			categories2.add(categoryCBoxOpt1.getSelectedItem().toString());
			logger.info("2");
		} else if(categoryCBoxOpt2.getSelectedItem()!=null){
			categories2.add(categoryCBoxOpt2.getSelectedItem().toString());
			logger.info("3");
		}else if(categoryCBoxOpt3.getSelectedItem()!=null){
			categories2.add(categoryCBoxOpt3.getSelectedItem().toString());
			logger.info("4");
		}else if(categoryCBoxOpt4.getSelectedItem()!=null){
			categories2.add(categoryCBoxOpt4.getSelectedItem().toString());
			logger.info("5");
		}else if(categoryCBoxOpt5.getSelectedItem()!=null){
			categories2.add(categoryCBoxOpt5.getSelectedItem().toString());
			logger.info("6");
		}
	}

	/**
	 * 
	 */
	public void designersToArray(){
		if(designerCBoxOpt1.getSelectedItem()!=null){
			designers2.add(designerCBoxOpt1.getSelectedItem().toString());
			logger.info("2");
		} else if(designerCBoxOpt2.getSelectedItem()!=null){
			designers2.add(designerCBoxOpt2.getSelectedItem().toString());
			logger.info("3");
		}else if(designerCBoxOpt3.getSelectedItem()!=null){
			designers2.add(designerCBoxOpt3.getSelectedItem().toString());
			logger.info("4");
		}
	}

	public boolean buy(){
		if(!owned.contains(listGames.getSelectedValue()))
			if(controller.buy(listGames.getSelectedValue())){
				owned.add(listGames.getSelectedValue());
				return true;
			} else
				return false;
		else{
			new JOptionPane("Already own that game", 1);
			return false;
		}
	}

}
