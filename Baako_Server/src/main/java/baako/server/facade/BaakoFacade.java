/**
 * 
 */
package baako.server.facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import baako.server.assemblers.Assembler;
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

	public PlainUserDTO checkUserInfo(String username, String password) throws RemoteException {
		System.out.println("FACADE-> CHECK USER INFO");
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

}
