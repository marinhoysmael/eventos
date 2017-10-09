package br.com.we.congressus.serviceImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import br.com.we.congressus.daoHbn.GenericDaoHbn;
import br.com.we.congressus.modelo.Conta;
import br.com.we.congressus.service.ContaService;

public class ContaServiceImpl extends ContaService{

	@Override
	public boolean verificarContaCadastrada(Conta conta) {
		GenericDaoHbn<Conta> contaDao = (GenericDaoHbn<Conta>) dao;
		
		Criteria criteria = contaDao.createCriteria();
		
		Criterion criteriaIdentificador =  Restrictions.eq("identificador", conta.getIdentificador());
		Criterion criteriaUID =  Restrictions.eq("UID", conta.getUID());
		
		criteria.add(Restrictions.or(criteriaIdentificador, criteriaUID));
		
		List<Conta> contas = criteria.list();
		
		if(contas.size() > 0 ){
			return true;
		}
		return false;
	}
}
