package com.eltonhoracio.carteiradourada.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.eltonhoracio.carteiradourada.domain.enums.TipoVeiculo;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Veiculo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String placa;
	private String renavan;
	private String chassi;
	private String marca;
	private String modelo;
	private Integer ano;
	private String cor;
	private Integer especie;
	
	@JsonBackReference
	@OneToOne
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa;
	
	public Veiculo() {
	}

	public Veiculo(Integer id, String placa, String renavan, String chassi, String marca, String modelo, Integer ano,
			String cor, TipoVeiculo especie, Pessoa pessoa) {
		super();
		this.id = id;
		this.placa = placa;
		this.renavan = renavan;
		this.chassi = chassi;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.especie = especie.getCodigo();
		this.pessoa = pessoa;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
