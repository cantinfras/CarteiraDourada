package com.eltonhoracio.carteiradourada.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eltonhoracio.carteiradourada.domain.Pessoa;
import com.eltonhoracio.carteiradourada.repositories.PessoaRepository;
import com.eltonhoracio.carteiradourada.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;
	
	public Pessoa find(Integer id) {
		Optional <Pessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " Tipo: " + Pessoa.class.getName()));
	}

}
