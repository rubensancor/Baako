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


	public Delegate_GUI(BaakoController controller){
		this.controller = controller;
		categories = new ArrayList<String>();
		designers = new ArrayList<String>();
	}

	/* (non-Javadoc)
	 * @see baako.client.gui.GUI#fill()
	 */
	public void fill(){
		logger.info("FILL");

		logger.info(controller.getAllCategories().get(0));
		categories.addAll(controller.getAllCategories());
		for (String string : categories) {
			categoryCBox.addItem(string);
			categoryCBoxOpt1.addItem(string);
			categoryCBoxOpt2.addItem(string);
			categoryCBoxOpt3.addItem(string);
			categoryCBoxOpt4.addItem(string);
			categoryCBoxOpt5.addItem(string);
		}

		logger.info(controller.getAllDesigners().get(0));
		designers.addAll(controller.getAllDesigners());
		for (String string : designers) {
			designerCBox.addItem(string);
			designerCBoxOpt1.addItem(string);
			designerCBoxOpt2.addItem(string);
			designerCBoxOpt3.addItem(string);
		}
	}


	/* (non-Javadoc)
	 * @see baako.client.gui.GUI#logIn(java.lang.String, java.lang.String)
	 */
	public boolean logIn(String username, String password){
		user = controller.logIn(username, password);
		if(user != null){
			return true;
		}else{
			new JOptionPane("ERROR IN THE LOGIN",1);
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
		logger.info("ADDING A GAME CONTROLLER");
		ArrayList<String> categories = new ArrayList<String>();
		categories.add(categoryCBox.getSelectedItem().toString());
		designers.add(designerCBox.getSelectedItem().toString());
		categoriesToArray();
		designersToArray();
		GameDTO g = new GameDTO(name, price, description, pegi);
		return controller.addGame(g);
	}
	
	public boolean addNews(String title, String body, Date date){
		NewsDTO n = new NewsDTO(title, body, date);
		return controller.addNews(n);
	}

	/**
	 * 
	 */
	public void categoriesToArray(){
		if(categoryCBoxOpt1.getSelectedItem().toString()!=""){
			categories.add(categoryCBoxOpt1.getSelectedItem().toString());
		} else if(categoryCBoxOpt2.getSelectedItem().toString()!=""){
			categories.add(categoryCBoxOpt2.getSelectedItem().toString());
		}else if(categoryCBoxOpt3.getSelectedItem().toString()!=""){
			categories.add(categoryCBoxOpt3.getSelectedItem().toString());
		}else if(categoryCBoxOpt4.getSelectedItem().toString()!=""){
			categories.add(categoryCBoxOpt4.getSelectedItem().toString());
		}else if(categoryCBoxOpt5.getSelectedItem().toString()!=""){
			categories.add(categoryCBoxOpt5.getSelectedItem().toString());
		}
	}
	
	/**
	 * 
	 */
	public void designersToArray(){
		if(designerCBoxOpt1.getSelectedItem().toString()!=""){
			designers.add(designerCBoxOpt1.getSelectedItem().toString());
		} else if(designerCBoxOpt2.getSelectedItem().toString()!=""){
			designers.add(designerCBoxOpt2.getSelectedItem().toString());
		}else if(designerCBoxOpt3.getSelectedItem().toString()!=""){
			designers.add(designerCBoxOpt3.getSelectedItem().toString());
		}
	}


}
