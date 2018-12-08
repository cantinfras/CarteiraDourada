package com.eltonhoracio.carteiradourada;


import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eltonhoracio.carteiradourada.domain.Multa;
import com.eltonhoracio.carteiradourada.domain.Pessoa;
import com.eltonhoracio.carteiradourada.domain.TipoMulta;
import com.eltonhoracio.carteiradourada.domain.Veiculo;
import com.eltonhoracio.carteiradourada.domain.enums.TipoVeiculo;
import com.eltonhoracio.carteiradourada.repositories.MultaRepository;
import com.eltonhoracio.carteiradourada.repositories.PessoaRepository;
import com.eltonhoracio.carteiradourada.repositories.TipoMultaRepository;
import com.eltonhoracio.carteiradourada.repositories.VeiculoRepository;


@SpringBootApplication
public class CarteiradouradaApplication implements CommandLineRunner {
	
	@Autowired
	private TipoMultaRepository tipoMultaRrepository;
	@Autowired
	private MultaRepository multaRepository;
	@Autowired
	private PessoaRepository pessoaRrepository;
	@Autowired
	private VeiculoRepository veiculoRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(CarteiradouradaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Pessoa pessoa1 = new Pessoa(null, "Elton Horácio Ramos", "05525660112", "932.053.416-00", "eltonhr2@hotmail.com", 30);
		Pessoa pessoa2 = new Pessoa(null, "Rosa Maria Moreira", "07823391220", "034.116.186-12", "mmr17@gmail.com", 15);
		
		Veiculo veiculo1 = new Veiculo(null, "HIJ-1833", "00462282953", "9C2KC1670CR526817", "Honda", "Fan-150 ESDI", 2012, "Cinza", TipoVeiculo.MOTOCICLETA, pessoa1);
		Veiculo veiculo2 = new Veiculo(null, "HJE-4493", "00462282953", "9C2KC1670CR526817", "Chevrolet", "Celta Spirit", 2008, "Cinza", TipoVeiculo.AUTOMOVEL, pessoa2);
		
		pessoaRrepository.saveAll(Arrays.asList(pessoa1, pessoa2));
		veiculoRepository.saveAll(Arrays.asList(veiculo1, veiculo2));
		
		TipoMulta tipo1 = new TipoMulta(null, "501-00", "DIRIGIR VEICULO SEM POSSUIR CNH PPD ACC", "Condutor", 7);
		TipoMulta tipo2 = new TipoMulta(null, "502-91", "DIRIGIR VEICULO COM CNH PPD ACC CASSADA", "Condutor", 7);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Multa multa1 = new Multa(null, sdf.parse("01/12/2018"), tipo1, pessoa1);
		Multa multa2 = new Multa(null, sdf.parse("02/12/2018"), tipo1, pessoa2);
		Multa multa3 = new Multa(null, sdf.parse("07/12/2018"), tipo2, pessoa2);
		
		tipo1.getMultas().addAll(Arrays.asList(multa1, multa2));
		tipo2.getMultas().addAll(Arrays.asList(multa3));
		
		tipoMultaRrepository.saveAll(Arrays.asList(tipo1, tipo2));
		multaRepository.saveAll(Arrays.asList(multa1, multa2, multa3));
		
	}
}
