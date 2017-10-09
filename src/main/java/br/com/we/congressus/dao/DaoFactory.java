package br.com.we.congressus.dao;

public interface DaoFactory {
	
	public <T> GenericDao<T> getCurrentDao(Class<T> klass);
}
