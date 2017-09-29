package br.com.eco.sac.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Participante {

	@Id
	@GeneratedValue
	private long id;
	
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private boolean daInstituicao;
	private String matricula;
	private String instituicao;
	private int qrCodeId;
	private boolean inscricaoPaga;
	private boolean inscricaoConfirmada;
	private Date dataCadastro;
	
	@ManyToOne
	private TipoInscricao tipoInscricao;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<Evento> eventos;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean isDaInstituicao() {
		return daInstituicao;
	}

	public void setDaInstituicao(boolean daInstituicao) {
		this.daInstituicao = daInstituicao;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public int getQrCodeId() {
		return qrCodeId;
	}

	public void setQrCodeId(int qrCodeId) {
		this.qrCodeId = qrCodeId;
	}

	public boolean isInscricaoPaga() {
		return inscricaoPaga;
	}

	public void setInscricaoPaga(boolean inscricaoPaga) {
		this.inscricaoPaga = inscricaoPaga;
	}

	public boolean isInscricaoConfirmada() {
		return inscricaoConfirmada;
	}

	public void setInscricaoConfirmada(boolean inscricaoConfirmada) {
		this.inscricaoConfirmada = inscricaoConfirmada;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public TipoInscricao getTipoInscricao() {
		return tipoInscricao;
	}

	public void setTipoInscricao(TipoInscricao tipoInscricao) {
		this.tipoInscricao = tipoInscricao;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
	
	
}
