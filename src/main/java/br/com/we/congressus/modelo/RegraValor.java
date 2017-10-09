package br.com.we.congressus.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RegraValor {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	private Evento evento;
	
	private Date dataInicio;
	
	private Date dataFim;
	
	private double valor;
	
	@Enumerated
	private TipoInscricao tipoInscricao;
	
	private String codigoPromocional;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public TipoInscricao getTipoInscricao() {
		return tipoInscricao;
	}

	public void setTipoInscricao(TipoInscricao tipoInscricao) {
		this.tipoInscricao = tipoInscricao;
	}

	public String getCodigoPromocional() {
		return codigoPromocional;
	}

	public void setCodigoPromocional(String codigoPromocional) {
		this.codigoPromocional = codigoPromocional;
	}
	
}
