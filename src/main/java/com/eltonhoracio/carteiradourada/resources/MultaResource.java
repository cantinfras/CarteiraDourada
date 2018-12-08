package com.eltonhoracio.carteiradourada.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eltonhoracio.carteiradourada.domain.Multa;
import com.eltonhoracio.carteiradourada.services.MultaService;

@RestController
@RequestMapping(value="/multa")
public class MultaResource {
	
	@Autowired
	private MultaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Multa obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
