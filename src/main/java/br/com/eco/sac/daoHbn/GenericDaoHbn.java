package br.com.eco.sac.daoHbn;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.eco.sac.dao.GenericDao;

public final class GenericDaoHbn <TypeObject> implements GenericDao<TypeObject>{

	private Session session;
	private Class<TypeObject> persistentClass;
	
	
	public GenericDaoHbn(Session session, Class<TypeObject> persistentClass){
		this.session = session;
		this.persistentClass = persistentClass;
	}

	//==========================================
	// Métodos do Hibernate
	//==========================================
	public Class<TypeObject> getPersistentClass() {
		return persistentClass;
	}
	
	public void setPersistentClass(Class<TypeObject> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public Session getSession() {
		return session;
	}


	public void setSession(Session session) {
		this.session = session;
	}

	public Criteria createCriteria() throws HibernateException   {	
		return session.createCriteria(persistentClass);
	}
	
	public String getClassName(){
		return persistentClass.getSimpleName();
	}
	
	//==========================================
	//Implementação do GenericDao
	//==========================================
	
	public boolean save(TypeObject typeObject)throws HibernateException{
		session.save(typeObject);
		return true;
	}
	
	public void saveOrUpdate(TypeObject typeObject) throws Exception {
		session.saveOrUpdate(typeObject);
	}
	
	public void update(TypeObject typeObject) throws Exception {
		session.update(typeObject);
	}
	
	public void delete(TypeObject typeObject) throws Exception {
		session.delete(typeObject);
	}
	
	public List<TypeObject> listAll() throws Exception {
		return  this.createCriteria().list();
	}
	
	public TypeObject loadById(long id) throws Exception {
		if(id <= 0) return null;
		return (TypeObject) session.get(persistentClass, id);
	}
	
}
