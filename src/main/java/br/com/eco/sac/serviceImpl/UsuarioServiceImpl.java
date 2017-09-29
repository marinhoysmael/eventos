package br.com.eco.sac.serviceImpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.eco.sac.daoHbn.GenericDaoHbn;
import br.com.eco.sac.model.Usuario;
import br.com.eco.sac.service.UsuarioService;

public class UsuarioServiceImpl extends UsuarioService{

	@Override
	public Usuario loadByLogin(String email) {
		GenericDaoHbn<Usuario> cidadeDao = (GenericDaoHbn<Usuario>) dao;
		Criteria criteria = cidadeDao.createCriteria();
		criteria.add(Restrictions.eq("login", email));
		return (Usuario) criteria.uniqueResult();
	}

}
