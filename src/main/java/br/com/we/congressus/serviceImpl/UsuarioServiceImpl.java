package br.com.we.congressus.serviceImpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.we.congressus.daoHbn.GenericDaoHbn;
import br.com.we.congressus.modelo.Usuario;
import br.com.we.congressus.service.UsuarioService;

public class UsuarioServiceImpl extends UsuarioService{

	@Override
	public Usuario loadByLogin(String email) {
		GenericDaoHbn<Usuario> cidadeDao = (GenericDaoHbn<Usuario>) dao;
		Criteria criteria = cidadeDao.createCriteria();
		criteria.add(Restrictions.eq("login", email));
		return (Usuario) criteria.uniqueResult();
	}

}
