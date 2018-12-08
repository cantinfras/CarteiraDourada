package com.eltonhoracio.carteiradourada.domain.enums;

public enum Infrator {
	
	PROPRIETARIO(1, "Proprietário"),
	CONDUTOR(2, "Condutor");
	
	private int codigo;
	private String descricao;
	
	private Infrator(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Infrator toEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}
		
		for (Infrator x : Infrator.values()) {
			if (codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}

}
