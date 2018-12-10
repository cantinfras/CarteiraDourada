package com.eltonhoracio.carteiradourada.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.eltonhoracio.carteiradourada.domain.TipoMulta;
import com.eltonhoracio.carteiradourada.dto.TipoMultaDTO;
import com.eltonhoracio.carteiradourada.repositories.TipoMultaRepository;
import com.eltonhoracio.carteiradourada.services.exceptions.DataIntegrityException;
import com.eltonhoracio.carteiradourada.services.exceptions.ObjectNotFoundException;

@Service
public class TipoMultaService {
	
	@Autowired
	private TipoMultaRepository repo;
	
	public TipoMulta find(Integer id) {
		Optional <TipoMulta> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " Tipo: " + TipoMulta.class.getName()));
	}
	
	public TipoMulta insert(TipoMulta obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public TipoMulta update(TipoMulta obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um tipo de multa que está incluido em uma multa.");
		}
	}
	
	public List<TipoMulta> findAll(){
		return repo.findAll();
	}
	
	public Page<TipoMulta> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public TipoMulta fromDTO(TipoMultaDTO objDto) {
		return new TipoMulta(objDto.getId(), objDto.getCodigo(),
				objDto.getDescricao(), objDto.getInfrator(), objDto.getPontos());
	}
}
