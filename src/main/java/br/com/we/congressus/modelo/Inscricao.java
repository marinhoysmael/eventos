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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 
 * @author ysmael
 *
 */

@Entity
public class Inscricao {

	private Date data;
	
	@ManyToOne
	private Evento evento;
	
	@Id
	@GeneratedValue
	private long id;
	
	private boolean isCredenciado;
	
	private boolean isPago;
	
	private String qrCode;
	
	@Enumerated
	private TipoInscricao tipoInscricao;
	
	@ManyToOne
	private Usuario usuario;
	
	private double valor;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "inscricaoId"), inverseJoinColumns = @JoinColumn(name = "atividadeId"))
	private List<Atividade> atividades;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isCredenciado() {
		return isCredenciado;
	}

	public void setCredenciado(boolean isCredenciado) {
		this.isCredenciado = isCredenciado;
	}

	public boolean isPago() {
		return isPago;
	}

	public void setPago(boolean isPago) {
		this.isPago = isPago;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public TipoInscricao getTipoInscricao() {
		return tipoInscricao;
	}

	public void setTipoInscricao(TipoInscricao tipoInscricao) {
		this.tipoInscricao = tipoInscricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	//TODO: Ver a forma de pagamento
	
	
	
}
