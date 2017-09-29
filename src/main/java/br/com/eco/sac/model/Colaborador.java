package br.com.eco.sac.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Colaborador {

	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private String matricula;
	private String cpf;
	
	@OneToOne
	private Usuario usuario;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Colaborador [id=" + id + ", nome=" + nome + ", matricula=" + matricula + ", cpf=" + cpf + ", usuario="
				+ usuario + "]";
	}
	
}
