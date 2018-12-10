package com.eltonhoracio.carteiradourada.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;

import com.eltonhoracio.carteiradourada.domain.TipoMulta;

public class TipoMultaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=3, max=8, message="O tamanho deve serm entre 3 e 8 caracteres")
	private String codigo;
	
	private String descricao;
	private String infrator;
	private Integer pontos;
	
	public TipoMultaDTO() {
	}
	
	public TipoMultaDTO(TipoMulta obj) {
		id = obj.getId();
		codigo = obj.getCodigo();
		descricao = obj.getDescricao();
		infrator = obj.getInfrator();
		pontos = obj.getPontos();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getInfrator() {
		return infrator;
	}

	public void setInfrator(String infrator) {
		this.infrator = infrator;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}
	
}