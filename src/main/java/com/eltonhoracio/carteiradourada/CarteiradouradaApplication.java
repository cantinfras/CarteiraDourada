package com.eltonhoracio.carteiradourada;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eltonhoracio.carteiradourada.services.S3Service;


@SpringBootApplication
public class CarteiradouradaApplication implements CommandLineRunner {
	
	@Autowired
	private S3Service s3Service;
	
	public static void main(String[] args) {
		SpringApplication.run(CarteiradouradaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		s3Service.uploadFile("C:\\temp\\Fotos\\01.jpg");
	}
	
	
}
