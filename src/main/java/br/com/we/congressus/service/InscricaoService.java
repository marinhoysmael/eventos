package br.com.we.congressus.service;

import br.com.we.congressus.dao.DaoFactory;
import br.com.we.congressus.modelo.TipoInscricao;

public abstract class InscricaoService extends RegraNegocioService<TipoInscricao>{

	@Override
	public void initDao(DaoFactory daoFactory) {
		dao = daoFactory.getCurrentDao(TipoInscricao.class);
	}

}
