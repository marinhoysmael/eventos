package br.com.eco.sac.serviceImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.eco.sac.daoHbn.DaoFactoryHbn;
import br.com.eco.sac.daoHbn.GenericDaoHbn;
import br.com.eco.sac.modelo.util.Cidade;
import br.com.eco.sac.service.CidadeService;

public class CidadeServiceImpl extends CidadeService{

	@Override
	public List<Cidade> listarPorEstado(long estadoId) throws Exception {
		GenericDaoHbn<Cidade> cidadeDao = (GenericDaoHbn<Cidade>) dao;
		Criteria criteria = cidadeDao.createCriteria();
		criteria.add(Restrictions.eq("estadoID", estadoId));
		return criteria.list();
	}
	
}
