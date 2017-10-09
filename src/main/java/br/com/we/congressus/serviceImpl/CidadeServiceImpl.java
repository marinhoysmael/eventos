package br.com.we.congressus.serviceImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.we.congressus.daoHbn.DaoFactoryHbn;
import br.com.we.congressus.daoHbn.GenericDaoHbn;
import br.com.we.congressus.modelo.util.Cidade;
import br.com.we.congressus.service.CidadeService;

public class CidadeServiceImpl extends CidadeService{

	@Override
	public List<Cidade> listarPorEstado(long estadoId) throws Exception {
		GenericDaoHbn<Cidade> cidadeDao = (GenericDaoHbn<Cidade>) dao;
		Criteria criteria = cidadeDao.createCriteria();
		criteria.add(Restrictions.eq("estadoID", estadoId));
		return criteria.list();
	}
	
}
