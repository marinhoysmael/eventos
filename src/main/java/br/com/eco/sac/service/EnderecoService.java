package br.com.eco.sac.service;

import br.com.eco.sac.dao.DaoFactory;
import br.com.eco.sac.modelo.util.Endereco;

public abstract class EnderecoService extends RegraNegocioService<Endereco> {
	
	@Override
	public void initDao(DaoFactory daoFactory) {
		dao = daoFactory.getCurrentDao(Endereco.class);
	}

}
