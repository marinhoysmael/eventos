package br.com.eco.sac.metaData;

import java.util.ArrayList;
import java.util.List;

import br.com.eco.sac.model.Atividade;

public class AtividadeVO {
	
	private long id;
	private String nome;
	private String horarioInicio;
	private String horarioFim;
	private long data;
	private List<Long> participantes;
	
	public AtividadeVO(Atividade atividade){
		this.id = atividade.getId();
		this.nome = atividade.getNome();
		this.horarioInicio = atividade.getHorarioInicio();
		this.horarioFim = atividade.getHorarioFim();
		this.data = atividade.getData().getTime();
		this.participantes = new ArrayList<Long>();
	}
	
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
	public String getHorarioInicio() {
		return horarioInicio;
	}
	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	public String getHorarioFim() {
		return horarioFim;
	}
	public void setHorarioFim(String horarioFim) {
		this.horarioFim = horarioFim;
	}
	public long getData() {
		return data;
	}
	public void setData(long data) {
		this.data = data;
	}
	public List<Long> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(List<Long> participantes) {
		this.participantes = participantes;
	}
	
	
	
	
}
