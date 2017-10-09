package br.com.we.congressus.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.mentawai.core.BaseAction;

import com.google.firebase.database.DatabaseReference;

import br.com.we.congressus.modelo.Atividade;
import br.com.we.congressus.service.AtividadeService;
import br.com.we.congressus.util.FirebaseUtil;

public class AtividadeAction extends BaseAction{

	private AtividadeService atividadeService;
	
	DatabaseReference databaseReference = FirebaseUtil.getDataBaseReference(Atividade.class.getSimpleName());
	 

	public void setAtividadeService(AtividadeService atividadeService) {
		
		this.atividadeService = atividadeService;
	}
	
	public String cadastro() throws Exception{
		List<Atividade> atividades = atividadeService.listAll();
		
		output.setValue("listAtividades", atividades);
		return SUCCESS;
	}
	
	public String salvar() throws Exception{
		Atividade atividade = new Atividade();
		input.inject(atividade);
		
		String data = input.getString("data");
		System.out.println(data);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		Date date = sdf.parse(data);
		
		atividade.setData(date);
		
		atividadeService.save(atividade);
		
//		databaseReference.child(""+atividade.getId()).setValue(new AtividadeVO(atividade));
		
		output.setValue("success", "Cadastro efetuado");
		return SUCCESS;
	}
	
	public String listar(){
		
		return SUCCESS;
	}

}
