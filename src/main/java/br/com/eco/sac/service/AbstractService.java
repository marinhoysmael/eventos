package br.com.eco.sac.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.eco.sac.dao.GenericDao;
import br.com.eco.sac.daoHbn.GenericDaoHbn;

public class AbstractService <TypeObject> extends Service<TypeObject>{

	
	public GenericDao<TypeObject> getDao() {
        if (dao == null) {
            throw new IllegalStateException("O Dao é NULL, possivelmente não foi injetado ou não foi implementado initDao na classe:" + this.getClass().getSuperclass().getSimpleName());
        }
        return dao;
    }
	
	
	@Override
	public void save(TypeObject typeObject) throws Exception {
		getDao().save(typeObject);
	}

	@Override
	public void update(TypeObject typeObject) throws Exception {
		getDao().update(typeObject);
	}

	@Override
	public void saveOrUpdate(TypeObject typeObject) throws Exception {
		getDao().saveOrUpdate(typeObject);
	}

	@Override
	public void delete(TypeObject typeObject) throws Exception {
		getDao().delete(typeObject);
		
	}

	@Override
	public List<TypeObject> listAll() throws Exception {
		return getDao().listAll();
	}

	@Override
	public TypeObject loadById(long id) throws Exception {
		return getDao().loadById(id);
	}
	
	
	@Override
	public TypeObject loadBy(String propert, Object value) {
		GenericDaoHbn<TypeObject> genericDao = (GenericDaoHbn<TypeObject>) dao;
		
		Criteria criteria = genericDao.createCriteria();
		criteria.add(Restrictions.eq(propert, value));
		return (TypeObject) criteria.uniqueResult();
	}
}
