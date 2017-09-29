package br.com.eco.sac.service;

import br.com.eco.sac.dao.DaoFactory;
import br.com.eco.sac.model.Usuario;

public abstract class UsuarioService extends RegraNegocioService<Usuario>{

	@Override
	public void initDao(DaoFactory daoFactory) {
		dao = daoFactory.getCurrentDao(Usuario.class);
	}

	public abstract Usuario loadByLogin(String login);
}
