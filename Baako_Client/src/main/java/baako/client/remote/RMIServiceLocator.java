/**
 * 
 */
package baako.client.remote;

import baako.server.manager.IBaakoManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 


/**
 * @author Baako-Team
 *
 */
public class RMIServiceLocator {

	Logger logger = LoggerFactory.getLogger(RMIServiceLocator.class);
	private IBaakoManager manager;

	public RMIServiceLocator(String IP, String port, String name){
		this.setManager(IP,port,name);
	}

	public void setManager(String IP, String port, String name) {

		String serverName="//"+ IP +":"+ port +"/"+ name ;
		try{
			logger.info("Estoy RMI");
			this.manager = (IBaakoManager) java.rmi.Naming.lookup(serverName);
			logger.info("He conectado");
		}catch(Exception e) {
			logger.error("- Exception running the client: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public IBaakoManager getService(){
		return manager;
	}
}
