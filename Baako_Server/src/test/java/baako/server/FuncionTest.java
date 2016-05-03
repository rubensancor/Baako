package baako.server;

import java.rmi.RemoteException;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import baako.server.auth.Auth;
import baako.server.dao.BaakoDAO;
import baako.server.database.PlainUser;
import baako.server.dto.PlainUserDTO;

public class FuncionTest {

	private static BaakoDAO dao;
	private static Auth a;
	private static PlainUser u;
	@BeforeClass 
	public static void setUpClass() throws Exception { 
		dao = new BaakoDAO();
		try {
			a = new Auth(dao);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	} 

	@Test 
	public void testCheckInfo() { 
		PlainUserDTO u = null;
		try {
			u = a.checkUserInfo("ruben", "asd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("ruben", u.getName());
	} 
	@Test(expected = NullPointerException.class)
	public void testWrongCheckInfo() { 
		PlainUserDTO u = null;
		try {
			u = a.checkUserInfo("txaahli", "asd");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		assertEquals(null , u.getName());
	} 

	@Test 
	public void testRegister() { 
		u = new PlainUser("gvirum@gmail.com", "GaizkaTere", "asd", new Date(System.currentTimeMillis()), null, null);
		PlainUserDTO u2 = null;
		try {
			a.register(u);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			u2 = a.checkUserInfo(u.getName(),u.getPassword());
		} catch (Exception e) {
			System.out.println("Ha cazao una excepcion "+e.getClass());
			e.printStackTrace();
		}
		assertEquals(u.getName(), u2.getName());
	} 

	@AfterClass 
	public static void tearDownClass() throws Exception { 
		dao.deleteUser("GaizkaTere");
	} 

}
