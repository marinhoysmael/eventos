package br.com.eco.sac.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.mentawai.core.BaseAction;
import org.mentawai.filter.AuthenticationFree;

import com.google.gson.Gson;

import br.com.eco.sac.model.Evento;
import br.com.eco.sac.modelo.util.Endereco;
import br.com.eco.sac.service.EnderecoService;
import br.com.eco.sac.service.EventoService;

public class EventoAction extends BaseAction implements AuthenticationFree{

	private EnderecoService enderecoService;
	private EventoService eventoService;

	public void setEnderecoService(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}
	
	public void setEventoService(EventoService eventoService) {
		this.eventoService = eventoService;
	}
	
	@Override
	public boolean bypassAuthentication(String innerAction) {

		if(innerAction.equals("listar") && input.getBoolean("isAjax"))
			return true;
		return false;
	}
	
	public String panel() {

		return SUCCESS;
	}

	public String cadastro() {

		return SUCCESS;
	}

	public String listar() throws Exception {

		System.err.println("OPA");
		if(input.getBoolean("isAjax", false)){
			List<Evento> eventos = eventoService.listAll();
			output.setValue("eventos", eventos);
			return AJAX;
		}
		
		return SUCCESS;
	}

	public String remover() {

		return SUCCESS;
	}
	
	public String salvar() throws Exception{
		
		Evento evento = new Evento();
		input.inject(evento);
		
		Endereco local = new Gson().fromJson(input.getString("local"), Endereco.class);
		
		enderecoService.save(local);
		
		evento.setLocal(local);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dataInicio = formatter.parse(input.getString("dataInicio"));
		Date dataFim = formatter.parse(input.getString("dataFim"));
		
		evento.setDataInicio(dataInicio);
		evento.setDataFim(dataFim);
		
		evento.setDataCadastro(new Date());
		evento.setDataAtualizacao(new Date());
		
		eventoService.save(evento);
		return SUCCESS;
	}

}
