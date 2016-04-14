package baako.authServer.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAuthServer extends Remote{

public boolean checkUserInfo(String username, String password) throws RemoteException;
public boolean register(String username, String password)throws RemoteException;
}
