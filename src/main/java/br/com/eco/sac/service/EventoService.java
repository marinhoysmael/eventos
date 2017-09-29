package br.com.eco.sac.service;

import br.com.eco.sac.dao.DaoFactory;
import br.com.eco.sac.model.Evento;

public abstract class EventoService extends RegraNegocioService<Evento>{
	
	@Override
	public void initDao(DaoFactory daoFactory) {
		// TODO Auto-generated method stub
		dao = daoFactory.getCurrentDao(Evento.class);
	}
}
