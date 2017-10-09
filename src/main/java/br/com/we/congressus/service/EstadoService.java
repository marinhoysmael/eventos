package br.com.we.congressus.service;

import br.com.we.congressus.dao.DaoFactory;
import br.com.we.congressus.modelo.util.Estado;

public class EstadoService extends RegraNegocioService<Estado>{

	@Override
	public void initDao(DaoFactory daoFactory) {
		// TODO Auto-generated method stub
		dao = daoFactory.getCurrentDao(Estado.class);
	}

}
