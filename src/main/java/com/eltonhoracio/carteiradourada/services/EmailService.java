package com.eltonhoracio.carteiradourada.services;

import org.springframework.mail.SimpleMailMessage;

import com.eltonhoracio.carteiradourada.domain.Pessoa;

public interface EmailService {
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Pessoa pessoa, String newPass);

}
