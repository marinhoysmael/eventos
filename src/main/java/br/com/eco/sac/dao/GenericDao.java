package br.com.eco.sac.dao;

import java.util.List;

public interface GenericDao <TypeObject>{
	
	boolean save(TypeObject typeObject) throws Exception;
	
	void update(TypeObject typeObject)throws Exception;
    
	void saveOrUpdate(TypeObject typeObject)throws Exception;
    
	void delete(TypeObject typeObject)throws Exception;
	
	List<TypeObject> listAll()throws Exception;
	
	public Class<TypeObject> getPersistentClass();
	
	TypeObject loadById(long id) throws Exception;
}
