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
		
		TipoMulta tipo1 = new TipoMulta(null, "500-20", "MULTA POR NAO IDENTIFICACAO DO CONDUTOR INFRATOR IMPOSTA A PESSOA JURIDICA", "Proprietário", 0);
		TipoMulta tipo2 = new TipoMulta(null, "501-00", "DIRIGIR VEICULO SEM POSSUIR CNH PPD ACC", "Condutor", 7);
		TipoMulta tipo3 = new TipoMulta(null, "502-91", "DIRIGIR VEICULO COM CNH PPD ACC CASSADA", "Condutor", 7);
		TipoMulta tipo4 = new TipoMulta(null, "502-92", "DIRIGIR VEICULO COM CNH PPD ACC COM SUSPENSAO DO DIREITO DE DIRIGIR", "Condutor", 7);
		TipoMulta tipo5 = new TipoMulta(null, "503-71", "DIRIGIR VEICULO COM CNH DE CATEGORIA DIFERENTE DA DO VEICULO", "Condutor", 7);
		TipoMulta tipo6 = new TipoMulta(null, "503-72", "DIRIGIR VEICULO COM PPD DE CATEGORIA DIFERENTE DA DO VEICULO", "Condutor", 7);
		TipoMulta tipo7 = new TipoMulta(null, "504-50", "DIRIGIR VEICULO COM VALIDADE DA CNH PPD VENCIDA HA MAIS DE 30 DIAS", "Condutor", 7);
		TipoMulta tipo8 = new TipoMulta(null, "505-31", "DIRIGIR VEICULO SEM USAR LENTES CORRETORAS DE VISAO", "Condutor", 7);
		TipoMulta tipo9 = new TipoMulta(null, "505-32", "DIRIGIR VEICULO SEM USAR APARELHO AUXILIAR DE AUDICAO", "Condutor", 7);
		TipoMulta tipo10 = new TipoMulta(null, "505-33", "DIRIGIR VEICULO SEM USAR APARELHO AUXILIAR DE PROTESE FISICA", "Condutor", 7);
		TipoMulta tipo11 = new TipoMulta(null, "505-34", "DIRIGIR VEICULO S ADAPTACOES IMPOSTAS NA CONCESSAO RENOVACAO LICENCA CONDUZIR", "Condutor", 7);
		TipoMulta tipo12 = new TipoMulta(null, "506-10", "ENTREGAR VEICULO A PESSOA SEM CNH PPD ACC", "Condutor", 7);
		TipoMulta tipo13 = new TipoMulta(null, "507-01", "ENTREGAR VEICULO A PESSOA COM CNH PPD ACC CASSADA", "Condutor", 7);
		TipoMulta tipo14 = new TipoMulta(null, "507-02", "ENTREGAR VEICULO A PESSOA COM CNH PPD ACC COM SUSPENSAO DO DIREITO DE DIRIGIR", "Condutor", 7);
		TipoMulta tipo15 = new TipoMulta(null, "508-81", "ENTREGAR VEICULO A PESSOA COM CNH DE CATEGORIA DIFERENTE DA DO VEICULO", "Condutor", 7);
		TipoMulta tipo16 = new TipoMulta(null, "508-82", "ENTREGAR VEICULO A PESSOA COM PPD DE CATEGORIA DIFERENTE DA DO VEICULO", "Condutor", 7);
		TipoMulta tipo17 = new TipoMulta(null, "509-60", "ENTREGAR VEICULO A PESSOA COM CNH PPD VENCIDA HA MAIS DE 30 DIAS", "Condutor", 7);
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Multa multa1 = new Multa(null, sdf.parse("01/12/2018"), tipo1, pessoa1);
		Multa multa2 = new Multa(null, sdf.parse("02/12/2018"), tipo1, pessoa2);
		Multa multa3 = new Multa(null, sdf.parse("07/12/2018"), tipo2, pessoa2);
		
		tipo1.getMultas().addAll(Arrays.asList(multa1, multa2));
		tipo2.getMultas().addAll(Arrays.asList(multa3));
		
		tipoMultaRrepository.saveAll(Arrays.asList(tipo1, tipo2, tipo3, tipo4, tipo5, tipo6, tipo7, tipo8, tipo9, tipo10, tipo11, tipo12, tipo13, tipo14, tipo15, tipo16, tipo17));
		multaRepository.saveAll(Arrays.asList(multa1, multa2, multa3));
		
	}
}
