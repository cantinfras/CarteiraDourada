package com.eltonhoracio.carteiradourada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eltonhoracio.carteiradourada.domain.Multa;

@Repository
public interface MultaRepository extends JpaRepository<Multa, Integer> {

}
