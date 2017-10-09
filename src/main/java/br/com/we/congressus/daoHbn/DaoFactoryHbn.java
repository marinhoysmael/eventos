package br.com.we.congressus.daoHbn;

import org.hibernate.Session;

import br.com.we.congressus.dao.DaoFactory;
import br.com.we.congressus.dao.GenericDao;

public class DaoFactoryHbn implements DaoFactory{
	
	private Session session;
	
	private static DaoFactoryHbn instance;
	
	public static DaoFactoryHbn getInstance() {
		if(instance == null)
			instance = new DaoFactoryHbn();
		
		return instance;
	}
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	public Session getSession() {
		return session;
	}

	public <T> GenericDao<T> getCurrentDao(Class<T> klass) {
		
		return new GenericDaoHbn<T>(session, klass);
	}


}
