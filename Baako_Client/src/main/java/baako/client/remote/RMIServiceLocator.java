/**
 * 
 */
package baako.client.remote;

import baako.server.manager.IBaakoManager;

/**
 * @author gusy
 *
 */
public class RMIServiceLocator {

	private IBaakoManager manager;

	public RMIServiceLocator(String IP, String port, String name){
		this.setManager(IP,port,name);
	}

	public void setManager(String IP, String port, String name) {

		String serverName="//"+ IP +":"+ port +"/"+ name ;
		try{
			System.out.println("Estoy RMI");
			this.manager = (IBaakoManager) java.rmi.Naming.lookup(serverName);
			System.out.println("He conectado");
		}catch(Exception e) {
			System.err.println("- Exception running the client: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public IBaakoManager getService(){
		return manager;
	}
}
