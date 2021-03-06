package com.eltonhoracio.carteiradourada.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eltonhoracio.carteiradourada.domain.Pessoa;
import com.eltonhoracio.carteiradourada.repositories.PessoaRepository;
import com.eltonhoracio.carteiradourada.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private PessoaRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Pessoa pes = repo.findByEmail(email);
		if(pes == null) {
			throw new UsernameNotFoundException(email);
		}		
		return new UserSS(pes.getId(), pes.getEmail(), pes.getSenha(), pes.getPerfis());
	}

}
