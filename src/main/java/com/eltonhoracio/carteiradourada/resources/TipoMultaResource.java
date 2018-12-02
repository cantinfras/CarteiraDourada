package com.eltonhoracio.carteiradourada.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eltonhoracio.carteiradourada.domain.TipoMulta;
import com.eltonhoracio.carteiradourada.services.TipoMultaService;

@RestController
@RequestMapping(value="/tiposMulta")
public class TipoMultaResource {
	
	@Autowired
	private TipoMultaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		TipoMulta obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
