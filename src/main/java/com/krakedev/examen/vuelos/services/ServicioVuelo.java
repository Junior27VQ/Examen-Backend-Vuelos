package com.krakedev.examen.vuelos.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krakedev.examen.vuelos.entities.Vuelos;
import com.krakedev.examen.vuelos.repositories.VueloRepository;

@Service
public class ServicioVuelo {
	private final VueloRepository repository;

	public ServicioVuelo(VueloRepository repository) {
		super();
		this.repository = repository;
	}
	public Vuelos crear(Vuelos vuelo) {
		return repository.save(vuelo);
	};
	public List<Vuelos> listar(){
		return repository.findAll();
	};
	public Vuelos buscarPorId(Integer id) {
		Optional<Vuelos> vuelo = repository.findById(id);
		return vuelo.orElse(null);
	};
	public Vuelos actualizar(Integer id, Vuelos vuelo) {
		Vuelos encontrado = buscarPorId(id);
		if(encontrado == null) {
			return null;
		}
		encontrado.setCodigo(vuelo.getCodigo());
		encontrado.setPrecioBoleto(vuelo.getPrecioBoleto());
		encontrado.setAsientosDisponibles(vuelo.getAsientosDisponibles());
		
		return repository.save(encontrado);
	};
	public boolean eliminar(Integer id) {
		Vuelos vuelo = buscarPorId(id);
		if(vuelo == null) {
			return false;
		}
		repository.deleteById(id);
		return true;
	};
	
	public List<Vuelos> buscarPorCodigo(String codigo){
		return repository.findByCodigo(codigo);
	}
	public List<Vuelos> buscarPorPrecio(BigDecimal precio){
		return repository.findByPrecioBoletoLessThan(precio);
	}

}
