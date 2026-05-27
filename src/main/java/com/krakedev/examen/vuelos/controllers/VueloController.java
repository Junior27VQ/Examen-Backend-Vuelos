package com.krakedev.examen.vuelos.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.examen.vuelos.entities.Vuelos;
import com.krakedev.examen.vuelos.services.ServicioVuelo;


@RestController
@RequestMapping("/api/vuelos")
public class VueloController {
	private final ServicioVuelo service;

	public VueloController(ServicioVuelo service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Vuelos vuelo){
		try {
			Vuelos nuevo = service.crear(vuelo);
			return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear vuelo: "+vuelo);
		}
	};
	
	@GetMapping
	public ResponseEntity<?> listar(){
		try {
			List<Vuelos> vuelo = service.listar();
			return ResponseEntity.ok(vuelo);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al listar los vuelos");
		}
	};
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
		try {
			Vuelos existe = service.buscarPorId(id);
			if(existe == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El vuelo con el id: "+id+" no fue encontrado");
			}
			return ResponseEntity.ok(existe);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar el vuelo");
		}
	};
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Vuelos vuelo){
		try {
			Vuelos actual = service.actualizar(id, vuelo);
			if(actual == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El vuelo con la id: "+id+" no existe");
			}
			return ResponseEntity.ok(actual);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar");
		}
	};
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id){
		try {
			boolean eliminado = service.eliminar(id);
			if(!eliminado) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El vuelo con la id: "+id+" no fue encontrado");
			}
			return ResponseEntity.ok("vuelo eliminado");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar");
		}
	};
	
	@GetMapping("/codigo")
	public ResponseEntity<?> buscarPorGenero(@RequestParam String codigo){
		try {
			List<Vuelos> vuelo=service.buscarPorCodigo(codigo);
			return ResponseEntity.ok(vuelo);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar por codigo");
		}
	};
	
	@GetMapping("/precio")
	public ResponseEntity<?> buscarPorCodigo(@RequestParam BigDecimal precio){
		try {
			List<Vuelos> vuelo=service.buscarPorPrecio(precio);
			return ResponseEntity.ok(vuelo);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar por precio");
		}
	};
}
