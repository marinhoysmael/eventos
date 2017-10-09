package br.com.we.congressus.action;

import org.mentawai.core.BaseAction;
import org.mentawai.filter.AuthenticationFree;

import br.com.we.congressus.service.CidadeService;

public class AdministracaoAction extends BaseAction implements AuthenticationFree{
	
	public boolean bypassAuthentication(String innerAction) {
		
		if(innerAction.equals("index"))
			return true;
		return false;
	}
	
	private CidadeService cidadeService;
	
	
	public void setCidadeService(CidadeService cidadeService) {
		this.cidadeService = cidadeService;
	}
	
	
	public String index() throws Exception{
		return SUCCESS;
		
	}
	
	public String dashboard() throws Exception{
		output.setValue("usuario", getUserSession());
//		output.setValue("listaParticipantes", participanteService.listAll());
		return SUCCESS;
	}
}
