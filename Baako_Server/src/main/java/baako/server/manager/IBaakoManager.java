/**
 * 
 */
package baako.server.manager;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import baako.server.dto.GameDTO;
import baako.server.dto.PlainUserDTO;

/**
 * @author gusy
 *
 */
public interface IBaakoManager  extends Remote{

public PlainUserDTO checkUserInfo(String username, String password) throws RemoteException;
public boolean register(PlainUserDTO user)throws RemoteException;

public boolean buyGame() throws RemoteException;
public boolean launchGame() throws RemoteException;
public boolean searchGame() throws RemoteException;
public boolean addWallet() throws RemoteException;

public boolean addGame(GameDTO g) throws RemoteException;


/**
 * @return All the categories from the DB
 * @throws RemoteException
 */
public ArrayList<String> getAllCategories() throws RemoteException;
/**
 * @return All the Designers from the DB
 * @throws RemoteException
 */
public ArrayList<String> getAllDesigners() throws RemoteException;

}
