package br.com.eco.sac.service;

import br.com.eco.sac.dao.DaoFactory;
import br.com.eco.sac.model.TipoInscricao;

public abstract class InscricaoService extends RegraNegocioService<TipoInscricao>{

	@Override
	public void initDao(DaoFactory daoFactory) {
		dao = daoFactory.getCurrentDao(TipoInscricao.class);
	}

}
