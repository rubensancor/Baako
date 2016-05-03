/**
 * 
 */
package baako.server.facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import baako.server.auth.Auth;
import baako.server.dao.BaakoDAO;
import baako.server.dao.IBaakoDAO;
import baako.server.database.PlainUser;
import baako.server.dto.PlainUserDTO;
import baako.server.manager.IBaakoManager;

/**
 * @author gusy
 *
 */
public class BaakoFacade extends UnicastRemoteObject implements IBaakoManager{

	private static final long serialVersionUID = -1814339868463815707L;


	private Auth auth;
	private BaakoDAO dao;
	/**
	 * @throws RemoteException
	 */
	public BaakoFacade(IBaakoDAO dao) throws RemoteException {
		this.dao = (BaakoDAO) dao;
		auth = new Auth(dao);
	}

	/* (non-Javadoc)
	 * @see baako.server.manager.IBaakoManager#checkUserInfo(java.lang.String, java.lang.String)
	 */
	@Override
	public PlainUserDTO checkUserInfo(String username, String password) throws RemoteException {
		return auth.checkUserInfo(username, password);
	}

	/* (non-Javadoc)
	 * @see baako.server.manager.IBaakoManager#register(baako.server.database.PlainUser)
	 */
	@Override
	public boolean register(PlainUser user) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see baako.server.manager.IBaakoManager#buyGame()
	 */
	//	@Override
	//	public boolean buyGame() {
	//		// TODO Auto-generated method stub
	//		return false;
	//	}
	//
	//	/* (non-Javadoc)
	//	 * @see baako.server.manager.IBaakoManager#launchGame()
	//	 */
	//	@Override
	//	public boolean launchGame() {
	//		// TODO Auto-generated method stub
	//		return false;
	//	}
	//
	//	/* (non-Javadoc)
	//	 * @see baako.server.manager.IBaakoManager#searchGame()
	//	 */
	//	@Override
	//	public boolean searchGame() {
	//		// TODO Auto-generated method stub
	//		return false;
	//	}
	//
	//	/* (non-Javadoc)
	//	 * @see baako.server.manager.IBaakoManager#addWallet()
	//	 */
	//	@Override
	//	public boolean addWallet() {
	//		// TODO Auto-generated method stub
	//		return false;
	//	}

}
