/**
 * 
 */
package baako.server.facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import baako.server.BaakoApp;
import baako.server.database.News;
import baako.server.dto.GameDTO;
import baako.server.dto.NewsDTO;
import baako.server.dto.PlainUserDTO;
import baako.server.manager.IBaakoManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 

/**
 * @author Baako-Team
 *
 */
public class BaakoFacade extends UnicastRemoteObject implements IBaakoManager{

	private static final long serialVersionUID = -1814339868463815707L;


	Logger logger = LoggerFactory.getLogger(BaakoFacade.class);
	private BaakoApp app;

	/** Constructor of the BaakoFacade class
	 * @param app A BaakoApp instance 
	 * @throws RemoteException
	 */
	public BaakoFacade(BaakoApp app) throws RemoteException {
		this.app = app;
	}

	/* (non-Javadoc)
	 * @see baako.server.manager.IBaakoManager#checkUserInfo(java.lang.String, java.lang.String)
	 */
	public PlainUserDTO checkUserInfo(String username, String password) throws RemoteException {
		return app.checkUserInfo(username, password);
	}

	/* (non-Javadoc)
	 * @see baako.server.manager.IBaakoManager#register(baako.server.dto.PlainUserDTO)
	 */
	public boolean register(PlainUserDTO user) throws RemoteException {
		return app.register(user);
	}

	/* (non-Javadoc)
	 * @see baako.server.manager.IBaakoManager#launchGame()
	 */
	public boolean launchGame() throws RemoteException{
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see baako.server.manager.IBaakoManager#addWallet(int, baako.server.dto.PlainUserDTO)
	 */
	public boolean addWallet(int cardNumber, PlainUserDTO u) throws RemoteException{
		return app.addWallet(cardNumber, u);
	}

	/* (non-Javadoc)
	 * @see baako.server.manager.IBaakoManager#addGame(baako.server.dto.GameDTO)
	 */
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

	/* (non-Javadoc)
	 * @see baako.server.manager.IBaakoManager#buyGame(baako.server.dto.GameDTO, baako.server.dto.PlainUserDTO)
	 */
	public boolean buyGame(GameDTO g, PlainUserDTO u) throws RemoteException {
		return app.buyGame(g, u);
	}

	/* (non-Javadoc)
	 * @see baako.server.manager.IBaakoManager#searchGame(java.lang.String)
	 */
	public GameDTO searchGame(String name) throws RemoteException {
		return app.searchGame(name);
	}

	/* (non-Javadoc)
	 * @see baako.server.manager.IBaakoManager#searchGamebyCategory(java.lang.String)
	 */
	public ArrayList<GameDTO> searchGamebyCategory(String category) throws RemoteException {
		return app.searchGamebyCategory(category);
	}

	/* (non-Javadoc)
	 * @see baako.server.manager.IBaakoManager#searchGamebyDesigner(java.lang.String)
	 */
	public ArrayList<GameDTO> searchGamebyDesigner(String designer) throws RemoteException {
		return app.searchGamebyDesigner(designer);
	}

	/* (non-Javadoc)
	 * @see baako.server.manager.IBaakoManager#addNews(baako.server.dto.NewsDTO)
	 */
	public boolean addNews(NewsDTO n) throws RemoteException {
		return app.addNews(n);
	}

	/* (non-Javadoc)
	 * @see baako.server.manager.IBaakoManager#getUsersGames(baako.server.dto.UserDTO)
	 */
	public ArrayList<GameDTO> getUsersGames(PlainUserDTO user) throws RemoteException {
		return app.getUserGames(user);
	}

	/* (non-Javadoc)
	 * @see baako.server.manager.IBaakoManager#getAllNews()
	 */
	public ArrayList<NewsDTO> getAllNews() throws RemoteException {
		logger.info("FACADE NEWS");
		return app.getAllNews();
	}
	


}

