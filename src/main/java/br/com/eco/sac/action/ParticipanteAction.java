package br.com.eco.sac.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mentawai.core.BaseAction;
import org.mentawai.filter.AuthenticationFree;

import com.google.firebase.database.DatabaseReference;

import br.com.eco.sac.metaData.AtividadeVO;
import br.com.eco.sac.metaData.ParticipanteVO;
import br.com.eco.sac.model.TipoInscricao;
import br.com.eco.sac.model.Participante;
import br.com.eco.sac.service.InscricaoService;
import br.com.eco.sac.service.ParticipanteService;
import br.com.eco.sac.util.FirebaseUtil;

public class ParticipanteAction  extends BaseAction implements AuthenticationFree{
	
	DatabaseReference databaseReference = FirebaseUtil.getDataBaseReference(Participante.class.getSimpleName());
	
	private InscricaoService inscricaoService;
	
	private ParticipanteService participanteService;
	
	public void setInscricaoService(InscricaoService inscricaoService) {
	
		this.inscricaoService = inscricaoService;
	}
	
	public void setParticipanteService(ParticipanteService participanteService) {
		this.participanteService = participanteService;
	}
	
	public boolean bypassAuthentication(String innerAction) {
		
		if(innerAction.equals("inscricao"))
			return true;
		
		if(innerAction.equals("salvar"))
			return true;
		
		if(innerAction.equals("certificado"))
			return true;
		return false;
	}

	
	public String inscricao() throws Exception {
		long eventoID = input.getLong("eventoID");
		
		List<TipoInscricao> inscricoes = inscricaoService.listAll();
		
		Map<Long, String> listaInscricoes = new HashMap<Long, String>();
		
		for(TipoInscricao inscricao : inscricoes){
			listaInscricoes.put(inscricao.getId(), inscricao.toString());
		}
		
		output.setValue("tipoInscricao", listaInscricoes);
		return SUCCESS;
	}
	
	
	public String salvar() throws Exception{
		Participante participante = new Participante();
		
		input.inject(participante);
		
		long tipoInscricao = input.getLong("inscricao");
		participante.setInscricao(inscricaoService.loadById(tipoInscricao));
		
		if(participante.isDaInstituicao()){
			participante.setInstituicao("FACULDADE DE EDUCACAO SAO FRANCISCO - FAESF");
		}
		
		if(participanteService.isCadastrado(participante)){
			output.setValue("error", "Os dados informados já estão cadastrados");
			return ERROR;
		}
		
		participante.setDataCadastro(new Date());
		participante.setInscricaoPaga(false);
		participante.setInscricaoConfirmada(false);
		participanteService.save(participante);
		
		output.setValue("participanteID", participante.getId());
		
		databaseReference.child(""+participante.getId()).setValue(new ParticipanteVO(participante));
		if(tipoInscricao == 2)
			output.setValue("submitFile", true);
		else
			output.setValue("submitFile", false);
		return SUCCESS;
	}
	
	public String listar() throws Exception{
		
		output.setValue("listaParticipantes", participanteService.listAll());
		return SUCCESS;
	}
	
	
	public String confimarInscricao() throws Exception{
		
		long id = input.getLong("participanteId");
		
	    Participante participante = participanteService.loadById(id);
		if(participante == null){
			output.setValue("error", "Participante não encontrado!");
			return ERROR;
		}
		
		if(participante.isInscricaoConfirmada()){
			output.setValue("error", "Inscrição já confirmada!");
			databaseReference.child(""+participante.getId()).child("inscricaoConfirmada").setValue(true);
			return ERROR;
		}
		
		if(!participante.isInscricaoPaga()){
			output.setValue("error", "Pagamento não confirmado!");
			return ERROR;
		}
		participante.setInscricaoConfirmada(true);
		
		participanteService.save(participante);
		
		databaseReference.child(""+participante.getId()).child("inscricaoConfirmada").setValue(true);
		return SUCCESS;
	}
	
	
	public String confimarPagamento() throws Exception{
		
		long id = input.getLong("participanteId");
		
	    Participante participante = participanteService.loadById(id);
		if(participante == null){
			output.setValue("error", "Participante não encontrado!");
			return ERROR;
		
		}
		
		if(participante.isInscricaoConfirmada()){
			output.setValue("error", "Inscrição já confirmada!");
			return ERROR;
		}
		
		if(participante.isInscricaoPaga()){
			output.setValue("error", "Pagamento já confirmado!");
			return ERROR;
		}
		participante.setInscricaoPaga(true);
		
		participanteService.save(participante);
		databaseReference.child(""+participante.getId()).child("inscricaoPaga").setValue(true);
		return SUCCESS;
	}
	
	public String gerarCracha() throws Exception{
		
		
		return SUCCESS;
	}
	
	public String updateInscricoesPagas() throws Exception{
		
		for(Participante participante : participanteService.listAll()){
			if(participante.isInscricaoPaga()){
				databaseReference.child(""+participante.getId()).child("inscricaoPaga").setValue(true);
			}
		}
		return SUCCESS;
	}
	
	
	public String updateParticipantes() throws Exception{
		for(Participante participante : participanteService.listAll()){
			databaseReference.child(""+participante.getId()).setValue(new ParticipanteVO(participante));
			
		}
		
		return SUCCESS;
	}
	
	public String certificado(){
		
		if(input.getBoolean("gerar")){
			
			if(!input.hasValue("cpf")){
				output.setValue("error", "Informe o CPF");
				return ERROR;
			}
			String cpf = input.getString("cpf");
			
			Participante participante = participanteService.loadBy("cpf", cpf);
			
			if(participante == null){
				output.setValue("error", "Participante não encontrado");
				return ERROR;
			}else{
				if(!participante.isInscricaoConfirmada()){
					output.setValue("error", "Sua inscricao nao foi confirmada");
					return ERROR;
				}
			}
			
			output.setValue("participanteNome", participante.getNome());
			output.setValue("eventoId", 1);
			output.setValue("participanteId", participante.getId());
			
			return AJAX;
		}
		return SUCCESS;
	}	
}
