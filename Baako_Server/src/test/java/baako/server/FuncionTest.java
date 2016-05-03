package baako.server;

import java.rmi.RemoteException;
import java.util.Date;

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
	@BeforeClass 
	public static void setUpClass() throws Exception { 
		dao = new BaakoDAO();
		try {
			a = new Auth(dao);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	} 
	//	@Before 
	//  public void setUp() throws Exception { 
	//      // Code executed before each test     
	//  } 
	@Test (expected = NullPointerException.class)
	public void testCheckInfo() { 
		PlainUserDTO u = null;
		try {
			u = a.checkUserInfo("ruben", "asd");
		} catch (RemoteException e) {
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

	@Test (expected = NullPointerException.class)
	public void testRegister() { 
		PlainUser u = new PlainUser("gvirum@gmail.com", "Gaizka", "asd", new Date(System.currentTimeMillis()), null, null);
		PlainUserDTO u2 = null;
		try {
			a.register(u);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			u2 = a.checkUserInfo(u.getName(), u.getPassword());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		assertEquals(u.getName(), u2.getName());
	} 
	//  @Test 
	//  public void testSomethingElse() { 
	//      // Code that tests something else 
	//  } 
	//  @After 
	//  public void tearDown() throws Exception { 
	//      // Code executed after each test    
	//  } 
	//  @AfterClass 
	//  public static void tearDownClass() throws Exception { 
	//      // Code executed after the last test method
	//  } 

}
//package baako.server;
//
//import java.rmi.RemoteException;
//import java.util.Date;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.assertEquals;
//import baako.server.auth.Auth;
//import baako.server.dao.BaakoDAO;
//import baako.server.database.PlainUser;
//import baako.server.dto.PlainUserDTO;
//
//public class FuncionTest {
//
//	private static BaakoDAO dao;
//	private static Auth a;
//	@BeforeClass 
//	public static void setUpClass() throws Exception { 
//		dao = new BaakoDAO();
//		try {
//			a = new Auth(dao);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//	} 
//
//	@Test 
//	public void testCheckInfo() { 
//		PlainUserDTO u = null;
//		try {
//			u = a.checkUserInfo("ruben", "asd");
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//		assertEquals("ruben", u.getName());
//	} 
//	@Test(expected = NullPointerException.class)
//	public void testWrongCheckInfo() { 
//		PlainUserDTO u = null;
//		try {
//			u = a.checkUserInfo("txaahli", "asd");
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//		assertEquals(null , u.getName());
//	} 
//
//	@Test 
//	public void testRegister() { 
//		PlainUser u = new PlainUser("gvirum@gmail.com", "Gaizka", "asd", new Date(System.currentTimeMillis()), null, null);
//		PlainUserDTO u2 = null;
//		try {
//			a.register(u);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//		try {
//			u2 = a.checkUserInfo(u.getName(), u.getPassword());
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//		assertEquals(u.getName(), u2.getName());
//	} 
//
//}
