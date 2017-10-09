package br.com.we.congressus.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mentawai.core.BaseAction;
import org.mentawai.filter.AuthenticationFree;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import br.com.we.congressus.modelo.Conta;
import br.com.we.congressus.modelo.Usuario;
import br.com.we.congressus.modelo.UsuarioSituacao;
import br.com.we.congressus.service.ContaService;
import br.com.we.congressus.service.UsuarioService;

public class UsuarioAction extends BaseAction implements AuthenticationFree{

	private ContaService contaService;
	private UsuarioService usuarioService;

	public void setContaService(ContaService contaService) {
		this.contaService = contaService;
	}
	
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@Override
	public boolean bypassAuthentication(String innerAction) {
		
		if(innerAction.equals("cadastro")) return true;
		if(innerAction.equals("salvar")) return true;
		return false;
	}
	
	
	
	public String cadastro(){
		
		return SUCCESS;
	}

	public String dashboard(){
		
		return SUCCESS;
	}
	
	public String salvar() throws Exception{
		Gson gson = new Gson();
		Conta conta = new Conta();

		JsonObject jsonObject = gson.fromJson(input.getString("conta"), JsonObject.class);
		
		contaService.inject(conta, jsonObject);
		
		System.err.println(conta);
		
		if(conta == null || contaService.verificarContaCadastrada(conta)){
			output.setValue("error", "Usuario ja cadastrado com esta conta");
			output.setValue("userMessage", "Usuario ja cadastrado com esta conta");
			return ACCESSDENIED;
		}
		
		Usuario usuario = new Usuario();
		input.inject(usuario);
		
		usuario.setDataCadastro(new Date());
		usuario.setDataAtualizacao(new Date());
		usuario.setSituacao(UsuarioSituacao.ATIVO);
		
		List<Conta> contas = new ArrayList<Conta>();
		contas.add(conta);
		conta.setUsuario(usuario);
		usuario.setContas(contas);
		
		usuarioService.save(usuario);
		return SUCCESS;
		
	}
}
