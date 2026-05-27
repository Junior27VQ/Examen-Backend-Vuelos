package com.krakedev.examen.vuelos.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krakedev.examen.vuelos.entities.Vuelos;

@Repository
public interface VueloRepository extends JpaRepository<Vuelos, Integer>{
	List<Vuelos> findByPrecioBoletoLessThan(BigDecimal precio);
	List<Vuelos> findByCodigo(String codigo);
}
