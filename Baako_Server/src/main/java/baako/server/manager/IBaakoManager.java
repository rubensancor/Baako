/**
 * 
 */
package baako.server.manager;

import java.rmi.Remote;
import java.rmi.RemoteException;

import baako.server.database.PlainUser;
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
}
