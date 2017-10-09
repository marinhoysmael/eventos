package br.com.we.congressus.service;

import br.com.we.congressus.dao.DaoFactory;
import br.com.we.congressus.modelo.Evento;

public abstract class EventoService extends RegraNegocioService<Evento>{
	
	@Override
	public void initDao(DaoFactory daoFactory) {
		// TODO Auto-generated method stub
		dao = daoFactory.getCurrentDao(Evento.class);
	}
}
