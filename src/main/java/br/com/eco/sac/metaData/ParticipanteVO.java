package br.com.eco.sac.metaData;

import br.com.eco.sac.model.Participante;

public class ParticipanteVO {
	
	private long id;
	private String nome;
	private String cpf;
	private boolean daInstituicao;
	private String matricula;
	private String instituicao;
	private int qrCodeId;
	private boolean inscricaoPaga;
	private boolean inscricaoConfirmada;
	private long dataCadastro;
	
	private long inscricaoID;
	
	
	public ParticipanteVO(Participante participante){
		
		this.id = participante.getId();
		this.nome = participante.getNome();
		this.cpf = participante.getCpf();
		this.daInstituicao = participante.isDaInstituicao();
		
		this.matricula = participante.getMatricula();
		this.instituicao = participante.getInstituicao();

		this.qrCodeId = participante.getQrCodeId();

		this.inscricaoPaga = participante.isInscricaoPaga();
		this.inscricaoConfirmada = participante.isInscricaoConfirmada();
		this.dataCadastro = participante.getDataCadastro().getTime();
		
//		this.inscricaoID = participante.getInscricao().getId();
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


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
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


	public long getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(long dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public long getInscricaoID() {
		return inscricaoID;
	}


	public void setInscricaoID(long inscricaoID) {
		this.inscricaoID = inscricaoID;
	}

	
}
