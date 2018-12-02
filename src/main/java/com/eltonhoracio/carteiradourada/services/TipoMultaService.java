package com.eltonhoracio.carteiradourada.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eltonhoracio.carteiradourada.domain.TipoMulta;
import com.eltonhoracio.carteiradourada.repositories.TipoMultaRepository;

@Service
public class TipoMultaService {
	
	@Autowired
	private TipoMultaRepository repo;
	
	public TipoMulta find(Integer id) {
		Optional <TipoMulta> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
