package br.com.eco.sac.service;

import br.com.eco.sac.dao.DaoFactory;
import br.com.eco.sac.model.Colaborador;

public abstract class ColaboradorService extends RegraNegocioService<Colaborador>{
	
	@Override
	public void initDao(DaoFactory daoFactory) {
		// TODO Auto-generated method stub
		dao = daoFactory.getCurrentDao(Colaborador.class);
	}

}
