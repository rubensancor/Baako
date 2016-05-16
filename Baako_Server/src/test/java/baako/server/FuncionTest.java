package baako.server;


import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import baako.server.auth.Auth;
import baako.server.dao.BaakoDAO;
import baako.server.database.PlainUser;
import baako.server.dto.PlainUserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 


public class FuncionTest {

	Logger logger = LoggerFactory.getLogger(Auth.class);
	private static BaakoDAO dao;
	private static Auth a;
	private static PlainUser u;
	@BeforeClass 
	public static void setUpClass() throws Exception { 
		dao = new BaakoDAO();
		a = new Auth(dao);
		a.register(new PlainUser("rubensancor@gmail.com", "Try", "asd", new Date()));
	} 

	@Test 
	public void testCheckInfo() { 
		PlainUserDTO u = null;
		try {
			u = a.checkUserInfo("Try", "asd");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertEquals("Try", u.getName());
	} 
	@Test(expected = NullPointerException.class)
	public void testWrongCheckInfo() { 
		PlainUserDTO u = null;
		try {
			u = a.checkUserInfo("txaahli", "asd");
		} catch (NullPointerException e){
			logger.warn("The user does not exist.");
		}
		assertEquals(null , u.getName());
	} 

	@Test 
	public void testRegister() { 
		u = new PlainUser("gvirum@gmail.com", "GaizkaTere", "asd", new Date(System.currentTimeMillis()));
		//		PlainUserDTO u2 = null;
			a.register(u);
		try {
			//			u2 = a.checkUserInfo(u.getName(),u.getPassword());
			logger.info("Copied");
		} catch (NullPointerException e1) {
			logger.info("Error en el check");
			e1.printStackTrace();
		}
		//		logger.info(u2.getName());
		//		assertEquals(u.getName(), u2.getName());
	} 

	@AfterClass 
	public static void tearDownClass() throws Exception { 
		dao.deleteUser("GaizkaTere");
		dao.deleteUser("Try");
	} 

}
