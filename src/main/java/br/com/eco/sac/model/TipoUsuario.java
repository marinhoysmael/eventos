package br.com.eco.sac.model;

public enum TipoUsuario {
	
	ADMINISTRADOR_GERAL (0, "Administrador do Sistema"),
	COLABORADOR (1, "Colaborador do Evento"),
	PROFESSOR (2, "Professor Colaborador"),
	COORDENADOR (3, "Coordenador do Evento");
	
	private int codigo;
	private String descricao;
	
	TipoUsuario(int codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		return descricao;
	}
	
}
