package br.com.we.congressus.service;

import java.util.List;

import br.com.we.congressus.dao.DaoFactory;
import br.com.we.congressus.modelo.util.Cidade;

public abstract class CidadeService extends RegraNegocioService<Cidade>{

	@Override
	public void initDao(DaoFactory daoFactory) {
		// TODO Auto-generated method stub
		dao = daoFactory.getCurrentDao(Cidade.class);
	}
	public abstract List<Cidade> listarPorEstado(long estadoId) throws Exception;
}
