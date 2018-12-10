package com.eltonhoracio.carteiradourada.dto;

import java.io.Serializable;

import com.eltonhoracio.carteiradourada.domain.Pessoa;

public class PessoaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String cnh;
	private String cpf;
	private String email;
	private Integer pontuacao;
	
	public PessoaDTO() {
	}
	
	public PessoaDTO(Pessoa obj) {
		id = obj.getId();
		nome = obj.getNome();
		cnh = obj.getCnh();
		cpf = obj.getCpf();
		email = obj.getEmail();
		pontuacao = obj.getPontuacao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
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

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}
	
}
