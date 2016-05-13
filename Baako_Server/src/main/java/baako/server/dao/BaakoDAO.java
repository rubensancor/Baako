/**
 * 
 */
package baako.server.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 

import javax.jdo.*;

import baako.server.database.Category;
import baako.server.database.Designer;
import baako.server.database.Game;
import baako.server.database.News;
import baako.server.database.PlainUser;
import baako.server.database.Wallet;
import baako.server.dao.IBaakoDAO;
/**
 * @author Baako-Team
 *
 */
public class BaakoDAO implements IBaakoDAO {

	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

	PersistenceManager pm = null;

	Transaction tx = null;

	Logger logger = LoggerFactory.getLogger(BaakoDAO.class);

	public PlainUser getUser(String username) throws NullPointerException{
		PlainUser aux2 = null;

		//DAO magic
		pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(1);
		tx = pm.currentTransaction();

		try{
			tx.begin();
			logger.info("Getting user '"+username+"' from the db:");
			//FUNCIONA
			//			Extent e = pm.getExtent(AdminUser.class, true);
			//			Iterator iter = e.iterator();
			//			while(iter.hasNext()){
			//				AdminUser aux = (AdminUser) iter.next();
			//				su = aux;
			//			}

			//			Query query = pm.newQuery(AdminUser.class);
			//			query.setFilter("username == usernameParam ");
			//			query.declareParameters("String usernameParam");
			//			query.setUnique(true);
			//
			//			aux = (User) query.execute(username);

			Query query = pm.newQuery("SELECT FROM "+PlainUser.class.getName()+" WHERE username=='"+username+"'");
			//			Query query2 = pm.newQuery(PlainUser.class);
			//			query2.setFilter("username == usernameParam ");
			//			query2.declareParameters("String usernameParam");
			query.setUnique(true);

			aux2 = (PlainUser) query.execute();
			PlainUser u = null;
			if(aux2 != null){
				logger.info("Retrieving "+aux2.toString()+" with password '"+aux2.getPassword()+"'");
				u = aux2;
			}else
				logger.warn("User '"+username+"' not found.");

			tx.commit();
			// Esto tiene que estar aqui, porque sino por alguna fuerza que desconozco, casca
			if(u != null)
				logger.info("Copied to an auxiliary var: "+u.getName()+", "+u.getPassword());
			return u;

		}catch(Exception e){
			e.printStackTrace();
			logger.warn("Exception when retrieving from database");
		}finally{
			if(tx.isActive()){
				tx.rollback();
			}
			pm.close();
		}
		return aux2;
	}

	/* (non-Javadoc)
	 * @see baako.server.dao.IBaakoDAO#addUser(baako.server.database.PlainUser)
	 */
	public void addUser(PlainUser user) {
		//DAO magic
		pm = pmf.getPersistenceManager();
		try{
			pm.makePersistent(user);
			logger.info("Registered "+user);
		}finally{
			pm.close();
		}		
	}
	
	/** Add a game to the DB without categories and designers
	 * @param game an instance of Game class
	 */
	public void addGamePlain(Game game){
		//DAO magic
		pm = pmf.getPersistenceManager();
		try{
			Game g1 = new Game(game.getName(), game.getPrice(), game.getDescription(), game.getPEGI());
			pm.makePersistent(g1);
		}finally{
		}
	}

	public void addGame(Game game){
		//DAO magic
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		try{
			tx.begin();
			addGamePlain(game);
			Query query = pm.newQuery("SELECT FROM "+Game.class.getName()+" WHERE name=='"+game.getName()+"'");
			query.setUnique(true);
			Game gaux = (Game) query.execute();
			gaux.setCategories(new HashSet<Category>());
			gaux.setDesigners(new HashSet<Designer>());
			for (Designer designer : game.getDesigners()) {
				logger.info(designer.getName());
				Query query2 = pm.newQuery("SELECT FROM "+Designer.class.getName()+" WHERE name=='"+designer.getName()+"'");
				query2.setUnique(true);
				Designer aux = (Designer) query2.execute();
				Designer det = pm.detachCopy(aux);
				gaux.addDesigner(det);
			}
			for (Category category : game.getCategories()) {
				Query query3 = pm.newQuery("SELECT FROM "+Category.class.getName()+" WHERE name=='"+category.getName()+"'");
				query3.setUnique(true);
				Category aux = (Category) query3.execute();
				Category det = pm.detachCopy(aux);
				gaux.addCategories(det);
			}
			tx.commit();
		}finally{
			if(tx.isActive()){
				tx.rollback();
			}
			pm.close();
		}
	}

	/* (non-Javadoc)
	 * @see baako.server.dao.IBaakoDAO#editGame(baako.server.database.Game)
	 */
	public void deleteGame(String game) {
		//DAOmagic
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		try{
			tx.begin();
			//TODO SELECT TO PREVENT THE SERVER FROM STOPPING
			Query query = pm.newQuery("DELETE FROM "+Game.class.getName()+" WHERE name=='"+game+"'");
			Long n = (Long) query.execute();
			tx.commit();

		}finally{
			if(tx.isActive()){
				tx.rollback();
			}
			pm.close();
		}
	}

	public void deleteUser(String user) {
		//DAOmagic
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		try{
			tx.begin();
			//TODO SELECT TO PREVENT THE SERVER FROM STOPPING
			Query query = pm.newQuery("DELETE FROM "+PlainUser.class.getName()+" WHERE username=='"+user+"'");
			Long n = (Long) query.execute();
			tx.commit();

		}finally{
			if(tx.isActive()){
				tx.rollback();
			}
			pm.close();
		}
	}

	/* (non-Javadoc)
	 * @see baako.server.dao.IBaakoDAO#getAllGames()
	 */
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

	/* (non-Javadoc)
	 * @see baako.server.dao.IBaakoDAO#getAllGames()
	 */
	public ArrayList<Category> getAllCategories() {
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		ArrayList<Category> categories= new ArrayList<Category>();
		try{
			tx.begin();
			Extent<Category> e = pm.getExtent(Category.class,true);
			Iterator<Category> iter = e.iterator();
			while (iter.hasNext())
			{
				Category aux = (Category) iter.next();
				logger.info(aux.getName());
				categories.add(aux);
			}
			tx.commit();
			return categories;

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
			logger.info("....Searching game....");
			tx.begin();
			Extent<Game> extent = pm.getExtent(Game.class, true);	
			for(Game game: extent){
				if(game.getName().equals(name)){
					games.add(game);

				}
			}		
			tx.commit();


		}catch(Exception ex){
			logger.error("   $ Error retreiving an extent: " + ex.getMessage());

		}finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();    		
		}

		return games.get(0);
	}

	/* (non-Javadoc)
	 * @see baako.server.dao.IBaakoDAO#getAllDesigners()
	 */
	public ArrayList<Designer> getAllDesigners() {
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		ArrayList<Designer> designers= new ArrayList<Designer>();
		try{
			tx.begin();
			Extent<Designer> e = pm.getExtent(Designer.class,true);
			Iterator<Designer> iter = e.iterator();
			while (iter.hasNext())
			{
				Designer aux = (Designer) iter.next();
				logger.info(aux.getName());
				designers.add(aux);
			}
			tx.commit();
			return designers;

		}finally{
			if(tx.isActive()){
				tx.rollback();
			}
			pm.close();
		}
	}

	public void addWallet(Wallet wallet, PlainUser u){
		//DAO magic
		pm = pmf.getPersistenceManager();
		try{
			u.setWallet(wallet);
			pm.makePersistent(u);
		}finally{
			if(tx.isActive()){
				tx.rollback();
			}
			pm.close();
		}
	}

	public void addFriend(PlainUser u, PlainUser u2){
		//DAO magic
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		try{
			tx.begin();
			Query query = pm.newQuery("SELECT FROM "+PlainUser.class.getName()+" WHERE username=='"+u.getName()+"'");
			query.setUnique(true);
			logger.info("BEFORE");
			PlainUser aux = (PlainUser) query.execute();
			logger.info("AFTER");
			Query query2 = pm.newQuery("SELECT FROM "+PlainUser.class.getName()+" WHERE username=='"+u2.getName()+"'");
			query2.setUnique(true);
			PlainUser aux2 = (PlainUser) query2.execute();
			PlainUser det = pm.detachCopy(aux2);
			aux.addFriend(det);
			tx.commit();
			//			pm.makePersistent(u2);
		}finally{
			if(tx.isActive()){
				tx.rollback();
			}
			pm.close();
		}
	}

	public void addNews(News n){
		//DAO magic
		pm = pmf.getPersistenceManager();
		try{
			pm.makePersistent(n);
		}finally{
			pm.close();
		}
	}

	public void buyGame(Game game, PlainUser user) {
		//DAO magic
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		try{
			tx.begin();
			Query query = pm.newQuery("SELECT FROM "+PlainUser.class.getName()+" WHERE username=='"+user.getName()+"'");
			query.setUnique(true);
			PlainUser aux = (PlainUser) query.execute();
			Query query2 = pm.newQuery("SELECT FROM "+Game.class.getName()+" WHERE name=='"+game.getName()+"'");
			query2.setUnique(true);
			Game gaux = (Game) query2.execute();
			Game det = pm.detachCopy(gaux);
			aux.addGame(det);
			tx.commit();
		}finally{
			if(tx.isActive()){
				tx.rollback();
			}
			pm.close();
		}

	}

	public ArrayList<Game> searchGamesByDesigner(String designer) {
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
				logger.info(aux.getName());
				for (Designer d : aux.getDesigners()) {
					if(d.getName().equals(designer))
						games.add(aux);
				}
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

	public ArrayList<Game> searchGamesByCategory(String category) {
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
				logger.info(aux.getName());
				for (Designer d : aux.getDesigners()) {
					if(d.getName().equals(category))
						games.add(aux);
				}
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
}
