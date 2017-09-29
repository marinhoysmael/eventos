package br.com.eco.sac.modelo.util;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.eco.sac.model.Usuario;

@Entity
public class RegistroAcesso {

	@Id
	@GeneratedValue
	private long id;
	private String action;
	private String innerAction;
	private long tempo;
	
	@ManyToOne
	private Usuario usuario;
	private String resultado;
	private Date data;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getInnerAction() {
		return innerAction;
	}
	public void setInnerAction(String innerAction) {
		this.innerAction = innerAction;
	}
	public long getTempo() {
		return tempo;
	}
	public void setTempo(long tempo) {
		this.tempo = tempo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
	
}
