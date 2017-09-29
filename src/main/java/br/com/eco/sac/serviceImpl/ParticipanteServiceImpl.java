package br.com.eco.sac.serviceImpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import br.com.eco.sac.daoHbn.GenericDaoHbn;
import br.com.eco.sac.model.Participante;
import br.com.eco.sac.service.ParticipanteService;

public class ParticipanteServiceImpl extends ParticipanteService{

	@Override
	public boolean isCadastrado(Participante participante) throws Exception {
		
		
		if(participante != null){
			GenericDaoHbn<Participante> participanteDao = (GenericDaoHbn<Participante>) dao;
			Criteria criteria = participanteDao.createCriteria();
			Disjunction or = Restrictions.disjunction();

			if(participante.getCpf() != null)
				or.add(Restrictions.eq("cpf", participante.getCpf()));
			
			if(participante.getEmail() != null)
				or.add(Restrictions.eq("email",participante.getEmail()));
			
			if(participante.getNome() != null){
				or.add(Restrictions.eq("nome", participante.getNome()));
			}

			criteria.add(or);
			
			if(criteria.list().size() > 0){
				return true;
			}else{
				return false;
			}
		}

		return false;
	}
}
