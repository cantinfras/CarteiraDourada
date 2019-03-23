package com.eltonhoracio.carteiradourada.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eltonhoracio.carteiradourada.domain.Multa;
import com.eltonhoracio.carteiradourada.domain.Pessoa;

@Repository
public interface MultaRepository extends JpaRepository<Multa, Integer> {
	
	@Transactional(readOnly=true)
	Page<Multa> findByPessoa(Optional<Pessoa> pessoa, Pageable pageRequest);

}
