package br.com.eco.sac.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * 
 * @author ysmael
 *
 */
@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private long id;
	private String login;
	private String senha;
	private Date ultimoAcesso;
	
	@Enumerated
	private TipoUsuario tipoUsuario;
	
	public long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}
	
	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}
	
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
}
