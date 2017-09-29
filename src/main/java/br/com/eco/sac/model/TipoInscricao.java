package br.com.eco.sac.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TipoInscricao {

	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private double valor;
	private int desconto;
	
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
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getDesconto() {
		return desconto;
	}
	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
