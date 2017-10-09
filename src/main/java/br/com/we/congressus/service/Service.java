package br.com.we.congressus.service;

import java.util.List;

import br.com.we.congressus.dao.GenericDao;


public abstract class Service<TypeObject>{

	protected GenericDao<TypeObject> dao;
	
	public GenericDao<TypeObject> getDao() {
		return dao;
	}
	
	public void setDao(GenericDao<TypeObject> dao) {
		this.dao = dao;
	}
	
	//==============================
	//Metodos do Service
	//==============================
	
    public abstract void save(TypeObject typeObject) throws Exception;
	
    public abstract void update(TypeObject typeObject)throws Exception;
    
	public abstract	void saveOrUpdate(TypeObject typeObject)throws Exception;
    
	public abstract void delete(TypeObject typeObject)throws Exception;
	
	public abstract List<TypeObject> listAll()throws Exception;
	
	public abstract TypeObject loadById(long id) throws Exception;
	
	public abstract TypeObject loadBy(String propert, Object value);
}
