package com.eltonhoracio.carteiradourada.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eltonhoracio.carteiradourada.domain.Veiculo;
import com.eltonhoracio.carteiradourada.repositories.VeiculoRepository;
import com.eltonhoracio.carteiradourada.services.exceptions.ObjectNotFoundException;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository repo;
	
	public Veiculo find(Integer id) {
		Optional <Veiculo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " Tipo: " + Veiculo.class.getName()));
	}

}
