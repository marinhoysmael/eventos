package br.com.we.congressus.service;

import br.com.we.congressus.dao.DaoFactory;
import br.com.we.congressus.modelo.util.Endereco;

public abstract class EnderecoService extends RegraNegocioService<Endereco> {
	
	@Override
	public void initDao(DaoFactory daoFactory) {
		dao = daoFactory.getCurrentDao(Endereco.class);
	}

}
