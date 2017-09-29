package br.com.eco.sac.service;

import br.com.eco.sac.dao.DaoFactory;
import br.com.eco.sac.model.Atividade;

public abstract class AtividadeService extends RegraNegocioService<Atividade> {

	@Override
	public void initDao(DaoFactory daoFactory) {
		// TODO Auto-generated method stub
		dao = daoFactory.getCurrentDao(Atividade.class);
	}

}
