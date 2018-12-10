package com.eltonhoracio.carteiradourada.dto;

import java.io.Serializable;

import com.eltonhoracio.carteiradourada.domain.Veiculo;
import com.eltonhoracio.carteiradourada.domain.enums.TipoVeiculo;

public class VeiculoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String placa;
	private String renavan;
	private String chassi;
	private String marca;
	private String modelo;
	private Integer ano;
	private String cor;
	private Integer especie;
	
	public VeiculoDTO() {
	}
	
	public VeiculoDTO(Veiculo obj) {
		id = obj.getId();
		placa = obj.getPlaca();
		renavan = obj.getRenavan();
		chassi = obj.getChassi();
		marca = obj.getMarca();
		modelo = obj.getModelo();
		ano = obj.getAno();
		cor = obj.getCor();
		especie = obj.getEspecie().getCodigo();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getRenavan() {
		return renavan;
	}

	public void setRenavan(String renavan) {
		this.renavan = renavan;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public TipoVeiculo getEspecie() {
		return TipoVeiculo.toEnum(especie);
	}

	public void setEspecie(TipoVeiculo especie) {
		this.especie = especie.getCodigo();
	}
	
}
