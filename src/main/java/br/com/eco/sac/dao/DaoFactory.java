package br.com.eco.sac.dao;

public interface DaoFactory {
	
	public <T> GenericDao<T> getCurrentDao(Class<T> klass);
}
