/**
 * 
 */
package baako.server.manager;

import java.rmi.Remote;
import java.rmi.RemoteException;

import baako.server.database.PlainUser;
import baako.server.dto.PlainUserDTO;
import baako.server.dto.UserDTO;

/**
 * @author gusy
 *
 */
public interface IBaakoManager  extends Remote{

public PlainUserDTO checkUserInfo(String username, String password) throws RemoteException;
public boolean register(PlainUser user)throws RemoteException;

//public boolean buyGame();
//public boolean launchGame();
//public boolean searchGame();
//public boolean addWallet();
}
