package com.eltonhoracio.carteiradourada;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eltonhoracio.carteiradourada.domain.Multa;
import com.eltonhoracio.carteiradourada.domain.TipoMulta;
import com.eltonhoracio.carteiradourada.repositories.MultaRepository;
import com.eltonhoracio.carteiradourada.repositories.TipoMultaRepository;


@SpringBootApplication
public class CarteiradouradaApplication implements CommandLineRunner {
	
	@Autowired
	private TipoMultaRepository tipoMultaRrepository;
	@Autowired
	private MultaRepository multaRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(CarteiradouradaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		TipoMulta tipo1 = new TipoMulta(null, "501-00", "DIRIGIR VEICULO SEM POSSUIR CNH PPD ACC", "CONDUTOR", 7);
		TipoMulta tipo2 = new TipoMulta(null, "501-00", "DIRIGIR VEICULO SEM POSSUIR CNH PPD ACC", "CONDUTOR", 7);
		
		Multa multa1 = new Multa(null, "01-12-2018", tipo1);
		Multa multa2 = new Multa(null, "02-12-2018", tipo1);
		Multa multa3 = new Multa(null, "07-12-2018", tipo2);
		
		tipo1.getMultas().addAll(Arrays.asList(multa1, multa2));
		tipo2.getMultas().addAll(Arrays.asList(multa3));
		
		tipoMultaRrepository.saveAll(Arrays.asList(tipo1, tipo2));
		multaRepository.saveAll(Arrays.asList(multa1, multa2, multa3));
	}
}
