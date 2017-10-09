package br.com.we.congressus.service;

import br.com.we.congressus.dao.DaoFactory;
import br.com.we.congressus.modelo.Atividade;

public abstract class AtividadeService extends RegraNegocioService<Atividade> {

	@Override
	public void initDao(DaoFactory daoFactory) {
		// TODO Auto-generated method stub
		dao = daoFactory.getCurrentDao(Atividade.class);
	}

}
