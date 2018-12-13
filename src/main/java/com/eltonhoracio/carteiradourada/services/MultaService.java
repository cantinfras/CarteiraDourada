package com.eltonhoracio.carteiradourada.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.eltonhoracio.carteiradourada.domain.Multa;
import com.eltonhoracio.carteiradourada.domain.Pessoa;
import com.eltonhoracio.carteiradourada.domain.TipoMulta;
import com.eltonhoracio.carteiradourada.dto.MultaDTO;
import com.eltonhoracio.carteiradourada.dto.MultaNewDTO;
import com.eltonhoracio.carteiradourada.repositories.MultaRepository;
import com.eltonhoracio.carteiradourada.repositories.PessoaRepository;
import com.eltonhoracio.carteiradourada.repositories.TipoMultaRepository;
import com.eltonhoracio.carteiradourada.services.exceptions.DataIntegrityException;
import com.eltonhoracio.carteiradourada.services.exceptions.ObjectNotFoundException;

@Service
public class MultaService {
	
	@Autowired
	private MultaRepository repo;
	
	@Autowired
	private TipoMultaRepository tipoMultaRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Multa find(Integer id) {
		Optional <Multa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " Tipo: " + Multa.class.getName()));
	}
	
	public Multa insert(Multa obj) {
		obj.setId(null);
		obj = repo.save(obj);
		pessoaRepository.save(obj.getPessoa());
		return obj;
	}
	
	public Multa update(Multa obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma multa que está associada a uma pessoa.");
		}
	}
	
	public List<Multa> findAll(){
		return repo.findAll();
	}
	
	public Page<Multa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Multa fromDTO(MultaDTO objDto) {
		return new Multa(objDto.getId(), objDto.getData(), null, null);
	}
	
	public Multa fromDTO(MultaNewDTO objDto) {
		Optional<TipoMulta> tipo = tipoMultaRepository.findById(objDto.getTipoId());
		Optional<Pessoa> pessoa = pessoaRepository.findById(objDto.getPessoaId());
		Multa multa = new Multa(null, objDto.getData(), tipo.get(), pessoa.get());
		return multa;
	}
}
