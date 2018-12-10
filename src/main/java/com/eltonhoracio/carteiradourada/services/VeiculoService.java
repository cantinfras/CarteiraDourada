package com.eltonhoracio.carteiradourada.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
	
	public Veiculo insert(Veiculo obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Veiculo update(Veiculo obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public List<Veiculo> findAll(){
		return repo.findAll();
	}
	
	public Page<Veiculo> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
