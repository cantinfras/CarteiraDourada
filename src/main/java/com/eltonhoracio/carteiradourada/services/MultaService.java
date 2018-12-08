package com.eltonhoracio.carteiradourada.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eltonhoracio.carteiradourada.domain.Multa;
import com.eltonhoracio.carteiradourada.repositories.MultaRepository;
import com.eltonhoracio.carteiradourada.services.exceptions.ObjectNotFoundException;

@Service
public class MultaService {
	
	@Autowired
	private MultaRepository repo;
	
	public Multa find(Integer id) {
		Optional <Multa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " Tipo: " + Multa.class.getName()));
	}

}
