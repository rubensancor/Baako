/**
 * 
 */
package baako.server.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.jdo.*;
import baako.server.database.AdminUser;
import baako.server.database.Game;
import baako.server.database.PlainUser;
import baako.server.database.User;
import baako.server.dao.IBaakoDAO;
/**
 * @author gusy
 *
 */
public class BaakoDAO implements IBaakoDAO {

	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

	PersistenceManager pm = null;

	Transaction tx = null;

	@SuppressWarnings("finally")
	public User getUser(String username){
		User aux = null;
		User aux2 = null;

		//DAO magic
		pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(1);
		tx = pm.currentTransaction();

		try{
			tx.begin();
			System.out.println("INFO: Getting a user from the db:");
			//FUNCIONA
			//			Extent e = pm.getExtent(AdminUser.class, true);
			//			Iterator iter = e.iterator();
			//			while(iter.hasNext()){
			//				AdminUser aux = (AdminUser) iter.next();
			//				su = aux;
			//			}

			Query query = pm.newQuery(AdminUser.class);
			query.setFilter("username == usernameParam ");
			query.declareParameters("String usernameParam");
			query.setUnique(true);

			aux = (User) query.execute(username);

			Query query2 = pm.newQuery(PlainUser.class);
			query2.setFilter("username == usernameParam ");
			query2.declareParameters("String usernameParam");
			query2.setUnique(true);

			aux2 = (User) query2.execute(username);


			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			if (pm != null && !pm.isClosed()) {
				System.out.println("CERRANDO");
				pm.close();
			}
			if(aux == null){
				return aux2;
			}else{
				System.out.println(aux.getEmail());
				return aux;
			}
		}
	}

	/* (non-Javadoc)
	 * @see baako.server.dao.IBaakoDAO#addUser(baako.server.database.PlainUser)
	 */
	@Override
	public void addUser(PlainUser user) {
		//DAO magic
		pm = pmf.getPersistenceManager();
		//		System.out.println(user.getName());
		try{
			pm.makePersistent(user);
		}finally{
			pm.close();
		}		
	}

	public void addGame(Game game){
		//DAO magic
		pm = pmf.getPersistenceManager();
		try{
			pm.makePersistent(game);
		}finally{
			pm.close();
		}


	}

	/* (non-Javadoc)
	 * @see baako.server.dao.IBaakoDAO#editGame(baako.server.database.Game)
	 */
	@Override
	public void deleteGame(String game) {
		//DAOmagic
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		try{
			tx.begin();
			//TODO SELECT TO PREVENT THE SERVER FROM STOPPING
			Query query = pm.newQuery("DELETE FROM "+game.getClass().getName()+" WHERE name=='"+game+"'");
			Long n = (Long) query.execute();
			tx.commit();

		}finally{
			if (tx != null && tx.isActive()) {
				System.out.println("There's no such game");
				tx.rollback();
			}
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
	}

	/* (non-Javadoc)
	 * @see baako.server.dao.IBaakoDAO#getAllGames()
	 */
	@Override
	public ArrayList<Game> getAllGames() {
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		ArrayList<Game> games= new ArrayList<Game>();
		try{
			tx.begin();

			Extent<Game> e = pm.getExtent(Game.class,true);
			Iterator<Game> iter = e.iterator();
			while (iter.hasNext())
			{
				Game aux = (Game) iter.next();
				games.add(aux);
			}
			tx.commit();
			return games;

		}finally{
			if(tx.isActive()){
				tx.rollback();
			}
			pm.close();
		}
	}
	



	public Game searchGame(String name){

		PersistenceManagerFactory pmf = JDOHelper
				.getPersistenceManagerFactory("Baako");
		// Persistence Manager
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<Game> games = new ArrayList<Game>();

		try{
			System.out.println("....Searching game....");
			tx.begin();
			Extent<Game> extent = pm.getExtent(Game.class, true);	
			for(Game game: extent){
				if(game.getName().equals(name)){
					games.add(game);

				}
			}		
			tx.commit();


		}catch(Exception ex){
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
			System.out.println("ERROR QUERY GAME DATABASE");

		}finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();    		
		}

		return games.get(0);
	}

	
	
}
