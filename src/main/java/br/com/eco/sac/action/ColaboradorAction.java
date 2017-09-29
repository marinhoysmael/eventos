package br.com.eco.sac.action;

import java.util.ArrayList;
import java.util.List;

import org.mentawai.core.BaseAction;

import br.com.eco.sac.model.Colaborador;
import br.com.eco.sac.model.TipoUsuario;
import br.com.eco.sac.model.Usuario;
import br.com.eco.sac.service.ColaboradorService;
import br.com.eco.sac.service.UsuarioService;
import br.com.eco.sac.util.ApplicationUtils;

public class ColaboradorAction extends BaseAction{

	private ColaboradorService colaboradorService;
	private UsuarioService usuarioService;
	
	public void setColaboradorService(ColaboradorService colaboradorService) {
	
		this.colaboradorService = colaboradorService;
	}
	
	public String cadastro() throws Exception{
		List<Colaborador> colaboradores = colaboradorService.listAll();
		
		
		output.setValue("listColaboradores", colaboradores);
		return SUCCESS;
	}
	
	public String salvar() throws Exception{
		Colaborador colaborador = new Colaborador();
		input.inject(colaborador);
		
		colaborador.setMatricula(input.getString("matriculaAluno"));

		if(colaboradorService.loadBy("cpf", colaborador.getCpf()) != null){
			output.setValue("error", "Os dados informados já estão cadastrados");
			return ERROR;
		}
		
		Usuario usuario = new Usuario();

		usuario.setLogin(colaborador.getCpf());
		usuario.setSenha(ApplicationUtils.criptografarSenha(colaborador.getMatricula()));
		usuario.setTipoUsuario(TipoUsuario.COLABORADOR);
		usuarioService.save(usuario);
		
		colaborador.setUsuario(usuario);
		
		colaboradorService.save(colaborador);
		
		output.setValue("success", "Cadastro efetuado");
		return SUCCESS;
	}
}
