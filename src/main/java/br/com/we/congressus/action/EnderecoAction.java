package br.com.we.congressus.action;

import org.mentawai.core.BaseAction;

import br.com.we.congressus.service.CidadeService;
import br.com.we.congressus.service.EstadoService;

public class EnderecoAction extends BaseAction{

	private CidadeService cidadeService;
	private EstadoService estadoService;
	
	public void setCidadeService(CidadeService cidadeService) {
		this.cidadeService = cidadeService;
	}
	
	public void setEstadoService(EstadoService estadoService) {
		this.estadoService = estadoService;
	}
	
	
	public String listarCidades() throws Exception{
		long estadoId = input.getLong("estadoId");
		
		if(estadoId > 0){
			output.setValue("cidades", cidadeService.listarPorEstado(estadoId));
		}
		return SUCCESS;
	}
	
	public String listarEstados() throws Exception{
		
		output.setValue("estados", estadoService.listAll());
		return SUCCESS;
	}
}
