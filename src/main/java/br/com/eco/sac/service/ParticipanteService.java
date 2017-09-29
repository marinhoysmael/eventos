package br.com.eco.sac.service;

import br.com.eco.sac.dao.DaoFactory;
import br.com.eco.sac.model.Participante;

public abstract class ParticipanteService extends RegraNegocioService<Participante>{

	@Override
	public void initDao(DaoFactory daoFactory) {
		// TODO Auto-generated method stub
		dao = daoFactory.getCurrentDao(Participante.class);
	}
	
	
	public abstract boolean isCadastrado(Participante participante) throws Exception;
}
