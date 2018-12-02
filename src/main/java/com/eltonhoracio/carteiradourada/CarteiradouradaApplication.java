package com.eltonhoracio.carteiradourada;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eltonhoracio.carteiradourada.domain.TipoMulta;
import com.eltonhoracio.carteiradourada.repositories.TipoMultaRepository;

@SpringBootApplication
public class CarteiradouradaApplication implements CommandLineRunner {
	
	@Autowired
	private TipoMultaRepository tipoMultaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarteiradouradaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		TipoMulta tipo1 = new TipoMulta(null, "501-00", "DIRIGIR VEICULO SEM POSSUIR CNH PPD ACC", 7);
		TipoMulta tipo2 = new TipoMulta(null, "502-91", "DIRIGIR VEICULO COM CNH PPD ACC CASSADA", 7);
		
		tipoMultaRepository.saveAll(Arrays.asList(tipo1, tipo2));
		
	}
}
