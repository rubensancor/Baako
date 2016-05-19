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

		categories.addAll(controller.getAllCategories());
		for (String string : categories) {
			values1.add(string);
		}

		designers.addAll(controller.getAllDesigners());
		for (String string : designers) {
			values3.add(string);
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
//		if (!owned.isEmpty()) owned.clear();
		logger.info("FILLING Owned");
		owned = controller.getUserGames();
		for (GameDTO gameDTO : owned) {
			logger.info(gameDTO.getName());
		}
		logger.info("All games retrieved");
	}

	public void fillPeople(){
		logger.info("FILLING People");
		people = controller.getAllUsers();
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
		categories2.addAll(values2);
		designers2.addAll(values4);
		GameDTO g = new GameDTO(name, price, description, pegi, "http://www.google.com/search?q="+name, categories2, designers2);
		games.add(g);
		return controller.addGame(g);
	}
	
	protected boolean editGame(int price, String text, int pegi) {
		String name = listGames.getSelectedValue().getName();
		categories2.addAll(values2);
		designers2.addAll(values4);
		for (GameDTO gameDTO : games) 
			if(gameDTO.getName().equals(listGames.getSelectedValue().getName())) games.remove(gameDTO);
		games.add( new GameDTO(name, price, text, pegi, "http://www.google.com/search?q="+name,values2, values4));
		return controller.editGame(name, price, text, pegi, values2, values4);
	}


	public boolean addNews(String title, String body, Date date){
		NewsDTO n = new NewsDTO(title, body, date);
		news.add(n);
		return controller.addNews(n);
	}

	/* (non-Javadoc)
	 * @see baako.client.gui.GUI#addFriend(baako.server.dto.PlainUserDTO)
	 */
	@Override
	public void addFriend(PlainUserDTO newFriend) {
		controller.addFriend(newFriend);
	}
	
	/* (non-Javadoc)
	 * @see baako.client.gui.GUI#deleteFriend(baako.server.dto.PlainUserDTO)
	 */
	@Override
	public void deleteFriend(PlainUserDTO oldFriend) {
		controller.deleteFriend(oldFriend);
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
