package com.eltonhoracio.carteiradourada.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.eltonhoracio.carteiradourada.domain.Pessoa;
import com.eltonhoracio.carteiradourada.dto.PessoaDTO;
import com.eltonhoracio.carteiradourada.repositories.PessoaRepository;
import com.eltonhoracio.carteiradourada.services.exceptions.DataIntegrityException;
import com.eltonhoracio.carteiradourada.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private PessoaRepository repo;
	
	public Pessoa find(Integer id) {
		Optional <Pessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " Tipo: " + Pessoa.class.getName()));
	}
	
	public Pessoa insert(Pessoa obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Pessoa update(Pessoa obj) {
		Pessoa newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma pessoa que possui veículo cadastrado.");
		}
	}
	
	public List<Pessoa> findAll(){
		return repo.findAll();
	}
	
	public Page<Pessoa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Pessoa fromDTO(PessoaDTO objDto) {
		return new Pessoa(objDto.getId(), objDto.getNome(), objDto.getCnh(),
				objDto.getCpf(), objDto.getEmail(), pe.encode(objDto.getSenha()));
	}
	
	private void updateData(Pessoa newObj, Pessoa obj) {
		newObj.setNome(obj.getNome());
		newObj.setCnh(obj.getCnh());
		newObj.setCpf(obj.getCpf());
		newObj.setEmail(obj.getEmail());
	}

}
