package br.com.we.congressus.action;

import java.util.Date;

import org.mentawai.action.BaseLoginAction;

import br.com.we.congressus.modelo.Usuario;
import br.com.we.congressus.service.UsuarioService;
import br.com.we.congressus.util.ApplicationUtils;

public class LoginAction extends BaseLoginAction {

	private UsuarioService usuarioService;
	
	public void setUsuarioService(UsuarioService usuarioService) {
	
		this.usuarioService = usuarioService;
	}
	
	public String login(){
		return SUCCESS;
	}
	public String efetuarLogin() throws Exception{
		
		String email = input.getString("usuario");
		String senha = input.getString("senha");
		
		Usuario usuario = usuarioService.loadByLogin(email);
		
		if(usuario == null){
			output.setValue("error", "Usuario não encontrado!");
			return ERROR;
		}else{
//			if(!usuario.getSenha().equals(ApplicationUtils.criptografarSenha(senha))){
//				output.setValue("error", "Usuario e senha não corresponde!");
//				return ERROR;
//			}
		}
		
//		usuario.setUltimoAcesso(new Date());
		
		usuarioService.saveOrUpdate(usuario);
		setUserSession(usuario);
		
		return SUCCESS;
	}
	
	public String logout(){
		setUserSession(null);
		
		return SUCCESS;
	}
}
