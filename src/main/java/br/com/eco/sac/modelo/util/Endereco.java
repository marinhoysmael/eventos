package br.com.eco.sac.modelo.util;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * 
 * @author ysmael
 *
 */
@Entity
public class Endereco {

	@Id
	@GeneratedValue
	private long ID;
	
	private String logradouro;
	private String numero;
	private String bairro;
	private String complemento;
	private String referencia;
	private String cep;
	
	@OneToOne
	private Cidade cidade;
	
	@OneToOne
	private Estado estado;
	
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Endereco [ID=" + ID + ", logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro
				+ ", complemento=" + complemento + ", referencia=" + referencia + ", cep=" + cep + ", cidade=" + cidade
				+ ", estado=" + estado + "]";
	}
	
	
}
