package com.eltonhoracio.carteiradourada.domain.enums;

public enum TipoVeiculo {
	
	BICICLETA(1, "Bicicleta"),
	CICLOMOTOR(2, "Ciclomotor"),
	MOTONETA(3, "Motoneta"),
	MOTOCICLETA(4, "Motocicleta"),
	TRICICLO(5, "Triciclo"),
	QUADRICICLO(6, "Quadriciclo"),
	AUTOMOVEL(7, "Automóvel"),
	MICROONIBUS(8, "Microônibus"),
	ONIBUS(9, "Onibus"),
	BONDE(10, "Bonde"),
	REBOQUE(11, "Reboque ou Semi-Reboque"),
	CHARRETE(12, "Charrete");
	
	private int codigo;
	private String descricao;
	
	private TipoVeiculo(int codigo, String descricao) {
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

	public static TipoVeiculo toEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}
		
		for (TipoVeiculo x : TipoVeiculo.values()) {
			if (codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
