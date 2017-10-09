package br.com.we.congressus.service;

import br.com.we.congressus.dao.DaoFactory;
import br.com.we.congressus.modelo.Usuario;

public abstract class UsuarioService extends RegraNegocioService<Usuario>{
	

	@Override
	public void initDao(DaoFactory daoFactory) {
		dao = daoFactory.getCurrentDao(Usuario.class);
	}

	public abstract Usuario loadByLogin(String login);
}
