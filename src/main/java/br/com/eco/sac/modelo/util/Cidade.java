package br.com.eco.sac.modelo.util;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cidade {
	@Id
	private long ID;
	
	private String nome;
	
	private long estadoID;
	
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public long getEstadoID() {
		return estadoID;
	}
	public void setEstadoID(long estadoID) {
		this.estadoID = estadoID;
	}
	
	@Override
	public String toString() {
		return "Cidade [ID=" + ID + ", nome=" + nome + ", estadoID=" + estadoID + "]";
	}
	
	
}
