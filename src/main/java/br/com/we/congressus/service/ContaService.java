package br.com.we.congressus.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import br.com.we.congressus.dao.DaoFactory;
import br.com.we.congressus.modelo.Conta;
import br.com.we.congressus.modelo.Provedor;
import br.com.we.congressus.util.ApplicationUtils;

public abstract class ContaService extends RegraNegocioService<Conta>{

	@Override
	public void initDao(DaoFactory daoFactory) {
		dao = daoFactory.getCurrentDao(Conta.class);
	}

	public abstract boolean verificarContaCadastrada(Conta conta);

	public void inject(Conta conta, JsonObject jsonObject) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		if(jsonObject == null) conta = null;
		
		if(jsonObject.has("identificador"))
			conta.setIdentificador(jsonObject.get("identificador").getAsString());
		
		if(jsonObject.has("provedor"))
			conta.setProvedor(new Gson().fromJson(jsonObject.get("provedor").getAsString(), Provedor.class));
		
		
		if(jsonObject.has("metaData"))
			conta.setMetaData(jsonObject.get("metaData").getAsJsonObject().toString());

		
		if(jsonObject.has("senha")){
			String senha = jsonObject.get("senha").getAsString();
			conta.setSenha(ApplicationUtils.criptografarSenha(senha));
		}
		
		if(jsonObject.has("UID"))
			conta.setUID(jsonObject.get("UID").getAsString());
		 
	}
}
