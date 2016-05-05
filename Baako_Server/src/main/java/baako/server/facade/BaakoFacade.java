/**
 * 
 */
package baako.server.facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import baako.server.assemblers.Assembler;
import baako.server.auth.Auth;
import baako.server.dao.BaakoDAO;
import baako.server.dao.IBaakoDAO;
import baako.server.database.Category;
import baako.server.database.Designer;
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
	private Auth auth;
	private BaakoDAO dao;
	/**
	 * @throws RemoteException
	 */
	public BaakoFacade(IBaakoDAO dao) throws RemoteException {
		this.dao = (BaakoDAO) dao;
		auth = new Auth(dao);
	}

	public PlainUserDTO checkUserInfo(String username, String password) throws RemoteException {
		logger.info("FACADE-> CHECK USER INFO");
		return auth.checkUserInfo(username, password);
	}

	public boolean register(PlainUserDTO user) throws RemoteException {
		System.out.println("FACADE-> REGISTER");
		System.out.println(user.getEmail());
		System.out.println(Assembler.getInstance().dissasemble(user));
		return auth.register(Assembler.getInstance().dissasemble(user));
	}

	public boolean buyGame() throws RemoteException{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean launchGame() throws RemoteException{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean searchGame() throws RemoteException{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addWallet() throws RemoteException{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addGame(GameDTO game) throws RemoteException{
		logger.info("ADD GAME FACADE");
		dao.addGame(Assembler.getInstance().disassemble(game));
		return true;
	}

	/* (non-Javadoc)
	 * @see baako.server.manager.IBaakoManager#getAllCategories()
	 */
	public ArrayList<String>  getAllCategories() throws RemoteException {
		ArrayList<Category> aux = dao.getAllCategories();
		ArrayList<String> aux2 = new ArrayList<String>();
		for (Category category : aux) {
			aux2.add(category.getName());
		}
		return aux2;	
	}

	/* (non-Javadoc)
	 * @see baako.server.manager.IBaakoManager#getAllDesigners()
	 */
	public ArrayList<String> getAllDesigners() throws RemoteException {
		ArrayList<Designer> aux = dao.getAllDesigners();
		ArrayList<String> aux2 = new ArrayList<String>();
		for (Designer designer : aux) {
			aux2.add(designer.getName());
		}
		return aux2;
	}

}

