package baako.server.auth;

import java.rmi.Remote;
import java.rmi.RemoteException;

import baako.server.database.PlainUser;

public interface IAuth extends Remote{

public boolean checkUserInfo(String username, String password) throws RemoteException;
public boolean register(PlainUser user)throws RemoteException;
}
