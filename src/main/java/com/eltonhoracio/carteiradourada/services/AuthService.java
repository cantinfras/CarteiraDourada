package com.eltonhoracio.carteiradourada.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.eltonhoracio.carteiradourada.domain.Pessoa;
import com.eltonhoracio.carteiradourada.repositories.PessoaRepository;
import com.eltonhoracio.carteiradourada.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailService emailService;
	
	private Random rand = new Random();

	public void sendNewPassword(String email) {
		
		Pessoa pessoa = pessoaRepository.findByEmail(email);
		if (pessoa == null) {
			throw new ObjectNotFoundException("Email não existe!");
		}
		
		String newPass = newPassword();
		pessoa.setSenha(pe.encode(newPass));
		
		pessoaRepository.save(pessoa);
		emailService.sendNewPasswordEmail(pessoa, newPass);
		
	}

	private String newPassword() {
		char[] vet = new char[9];
		for (int i=0; i<9; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if (opt == 0) { // gera um dígito
			return (char) (rand.nextInt(10) + 48);
		}
		else if (opt == 1) { //gera letra maiuscula
			return (char) (rand.nextInt(26) + 65);
		}
		else { //gera letra minúscula
			return (char) (rand.nextInt(26) + 97);
		}
	}
	
	
}
