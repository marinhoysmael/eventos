package br.com.we.congressus.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * 
 * @author ysmael
 *
 */
@Entity
public class Usuario {

	private Date dataAtualizacao;
	
	private Date dataCadastro;
	
	private String emailContato;
	
	@Id
	@GeneratedValue
	private long id;

	private String imagemURL;
	
	private String telefone;
	
	private String nome;
	
	@Enumerated
	private UsuarioSituacao situacao;
	
	@OneToMany
	private List<Inscricao> inscricoes;

	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "usuarioId"), inverseJoinColumns = @JoinColumn(name = "instituicaoId"))
	private List<Instituicao> instituicoes;
	
	@OneToMany
	@Cascade({CascadeType.SAVE_UPDATE})
	private List<Conta> contas;

	
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

	public String getEmailContato() {
		return emailContato;
	}

	public void setEmailContato(String emailContato) {
		this.emailContato = emailContato;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImagemURL() {
		return imagemURL;
	}

	public void setImagemURL(String imagemURL) {
		this.imagemURL = imagemURL;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UsuarioSituacao getSituacao() {
		return situacao;
	}

	public void setSituacao(UsuarioSituacao situacao) {
		this.situacao = situacao;
	}

	public List<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}

	public List<Instituicao> getInstituicoes() {
		return instituicoes;
	}
	
	public void setInstituicoes(List<Instituicao> instituicoes) {
		this.instituicoes = instituicoes;
	}
	
	public List<Conta> getContas() {
		return contas;
	}
	
	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	@Override
	public String toString() {
		return "Usuario [dataAtualizacao=" + dataAtualizacao + ", dataCadastro=" + dataCadastro + ", emailContato="
				+ emailContato + ", id=" + id + ", imagemURL=" + imagemURL + ", telefone=" + telefone + ", nome=" 
				+ nome + ", situacao=" + situacao + ", inscricoes=" + inscricoes + ", instituicoes="
				+ instituicoes + ", contasExtras=" + contas + "]";
	}
	
	
	
	
}
