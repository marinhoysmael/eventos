package br.com.we.congressus.modelo;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Conta {

	@Id
	@GeneratedValue
	private long id;
	
	private String identificador;
	
	/*
	 * JSON de valores não identificados
	 */
	private String metaData;

	@Enumerated
	private Provedor provedor;
	
	private String senha;
	
	private String UID;
	
	@ManyToOne
	private Usuario usuario;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String indentificador) {
		this.identificador = indentificador;
	}

	public String getMetaData() {
		return metaData;
	}

	public void setMetaData(String metaData) {
		this.metaData = metaData;
	}

	public Provedor getProvedor() {
		return provedor;
	}

	public void setProvedor(Provedor provedor) {
		this.provedor = provedor;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "ContaExtra [id=" + id + ", indentificador=" + identificador + ", metaData=" + metaData + ", provedor="
				+ provedor + ", UID=" + UID + ", usuario=" + usuario + "]";
	}
	
	
	
}
