package com.eltonhoracio.carteiradourada.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eltonhoracio.carteiradourada.domain.Multa;
import com.eltonhoracio.carteiradourada.dto.MultaDTO;
import com.eltonhoracio.carteiradourada.services.MultaService;

@RestController
@RequestMapping(value="/multas")
public class MultaResource {
	
	@Autowired
	private MultaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Multa> find(@PathVariable Integer id) {
		Multa obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<MultaDTO>> findAll() {
		List<Multa> list = service.findAll();
		List<MultaDTO> listDto = list.stream().map(obj -> new MultaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
