package com.eltonhoracio.carteiradourada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eltonhoracio.carteiradourada.domain.TipoMulta;

@Repository
public interface TipoMultaRepository extends JpaRepository<TipoMulta, Integer> {

}
