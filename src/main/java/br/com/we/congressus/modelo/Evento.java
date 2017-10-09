package br.com.we.congressus.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.we.congressus.modelo.util.Endereco;

@Entity
public class Evento {
	
	private Date dataAtualizacao;
	
	private Date dataCadastro;

	private Date dataFim;

	private Date dataInicio;
	
	private int edicao;
	
	@Id
	@GeneratedValue
	private long id;
	
	private String nome;
	
	private String tema;
	
	@ManyToOne
	private Usuario representante;
	
	private String realizacao;
	@ManyToOne
	private Instituicao instituicao;
	
	@OneToOne
	private Endereco local;
	
	@OneToMany
	private List<Atividade> atividades;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Inscricao> inscricoes;

	@OneToMany
	private List<RegraValor> regraValores;
	
	
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
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

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Usuario getRepresentante() {
		return representante;
	}

	public void setRepresentante(Usuario representante) {
		this.representante = representante;
	}

	public String getRealizacao() {
		return realizacao;
	}

	public void setRealizacao(String realizacao) {
		this.realizacao = realizacao;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public Endereco getLocal() {
		return local;
	}

	public void setLocal(Endereco local) {
		this.local = local;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public List<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}

	
	public List<RegraValor> getRegraValores() {
		return regraValores;
	}
	
	public void setRegraValores(List<RegraValor> regraValores) {
		this.regraValores = regraValores;
	}
	
}
