/**
 * 
 */
package baako.server.facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import baako.server.BaakoApp;
import baako.server.assemblers.Assembler;
import baako.server.auth.Auth;
import baako.server.dao.BaakoDAO;
import baako.server.dao.IBaakoDAO;
import baako.server.database.Category;
import baako.server.database.Designer;
import baako.server.database.Game;
import baako.server.database.PlainUser;
import baako.server.database.Wallet;
import baako.server.dto.GameDTO;
import baako.server.dto.PlainUserDTO;
import baako.server.manager.IBaakoManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 

/**
 * @author gusy
 *
 */
public class BaakoFacade extends UnicastRemoteObject implements IBaakoManager{

	private static final long serialVersionUID = -1814339868463815707L;


	Logger logger = LoggerFactory.getLogger(BaakoFacade.class);
	private BaakoApp app;
	/**
	 * @throws RemoteException
	 */
	public BaakoFacade(BaakoApp app) throws RemoteException {
		this.app = app;
	}

	public PlainUserDTO checkUserInfo(String username, String password) throws RemoteException {
		return app.checkUserInfo(username, password);
	}

	public boolean register(PlainUserDTO user) throws RemoteException {
		return app.register(user);
	}

	public boolean launchGame() throws RemoteException{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addWallet(int cardNumber, PlainUserDTO u) throws RemoteException{
		return app.addWallet(cardNumber, u);
	}

	public boolean addGame(GameDTO game) throws RemoteException{
		return app.addGame(game);
	}

	/* (non-Javadoc)
	 * @see baako.server.manager.IBaakoManager#getAllCategories()
	 */
	public ArrayList<String>  getAllCategories() throws RemoteException {
		return app.getAllCategories();	
	}

	/* (non-Javadoc)
	 * @see baako.server.manager.IBaakoManager#getAllDesigners()
	 */
	public ArrayList<String> getAllDesigners() throws RemoteException {
		return app.getAllDesigners();
	}

	public boolean buyGame(GameDTO g, PlainUserDTO u) throws RemoteException {
		return app.buyGame(g, u);
	}

	public GameDTO searchGame(String name) throws RemoteException {
		return app.searchGame(name);
	}

	public ArrayList<GameDTO> searchGamebyCategory(String category) throws RemoteException {
		return app.searchGamebyCategory(category);
	}

	public ArrayList<GameDTO> searchGamebyDesigner(String designer) throws RemoteException {
		return app.searchGamebyDesigner(designer);
	}

}

