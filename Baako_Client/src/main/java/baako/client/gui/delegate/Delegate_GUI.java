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
import baako.server.dto.PlainUserDTO;

/**
 * @author gusy
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

	
	public boolean logIn(String username, String password){
		if(controller.logIn(username, password)){
//			new Delegate_MainWindow();
			return true;
		}else{
			new JOptionPane("ERROR IN THE LOGIN",1);
			return false;
		}
	}
	
	public boolean  register(String email, String username, String password, Date date){
		logger.info("VAMOS A REGISTRAR");
		PlainUserDTO u = new PlainUserDTO(email, username, password, date, null, null);
		logger.info(u.getEmail());
		controller.register(u);
//		if(controller.register(username, password)){
//			return true;
//		}else{
//			new JOptionPane("YOU ARE ALREADY REGISTERED");
//			return false;
//		}
		return true;
	}
	
	public boolean addGame(String name, int price, String description, int pegi){
		logger.info("ADDING A GAME CONTROLLER");
		ArrayList<String> categories = new ArrayList<String>();
		categories.add(categoryCBox.getSelectedItem().toString());
		GameDTO g = new GameDTO(name, price, description, pegi);
		return controller.addGame(g);
	}


}
