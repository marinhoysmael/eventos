package br.com.we.congressus.service;

import br.com.we.congressus.dao.DaoFactory;

public abstract class RegraNegocioService<TypeObject> extends AbstractService<TypeObject>{
	private DaoFactory daoFactory;
	
	
	public abstract void initDao(DaoFactory daoFactory);
	
	public void setDaoFactory(DaoFactory daoFactory){
		this.daoFactory = daoFactory;
		initDao(daoFactory);
	}
	
	public DaoFactory getDaoFactory() {
		return daoFactory;
	}
	
}
