package br.com.eco.sac.action;

import org.mentawai.core.BaseAction;
import org.mentawai.filter.AuthenticationFree;

import br.com.eco.sac.service.CidadeService;
import br.com.eco.sac.service.ParticipanteService;

public class AdministracaoAction extends BaseAction implements AuthenticationFree{
	
	public boolean bypassAuthentication(String innerAction) {
		
		if(innerAction.equals("index"))
			return true;
		return false;
	}
	
	private CidadeService cidadeService;
	private ParticipanteService participanteService;
	
	
	public void setCidadeService(CidadeService cidadeService) {
		this.cidadeService = cidadeService;
	}
	
	public void setParticipanteService(ParticipanteService participanteService) {
		this.participanteService = participanteService;
	}
	
	public String index() throws Exception{
		return SUCCESS;
		
	}
	
	public String dashboard() throws Exception{
		output.setValue("usuario", getUserSession());
		output.setValue("listaParticipantes", participanteService.listAll());
		return SUCCESS;
	}
}
