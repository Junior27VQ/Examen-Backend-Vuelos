package com.krakedev.examen.vuelos.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name="vuelos")
public class Vuelos {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String codigo;

    @Column(name = "precio_boleto", nullable = false)
    private BigDecimal precioBoleto;

    @Column(name = "asientos_disponibles", nullable = false)
    private Integer asientosDisponibles;

	public Vuelos() {
		super();
	}

	public Vuelos(String codigo, BigDecimal precioBoleto, Integer asientosDisponibles) {
		super();
		this.codigo = codigo;
		this.precioBoleto = precioBoleto;
		this.asientosDisponibles = asientosDisponibles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getPrecioBoleto() {
		return precioBoleto;
	}

	public void setPrecioBoleto(BigDecimal precioBoleto) {
		this.precioBoleto = precioBoleto;
	}

	public Integer getAsientosDisponibles() {
		return asientosDisponibles;
	}

	public void setAsientosDisponibles(Integer asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
	}

	@Override
	public String toString() {
		return "Vuelos [id=" + id + ", codigo=" + codigo + ", precioBoleto=" + precioBoleto + ", asientosDisponibles="
				+ asientosDisponibles + "]";
	}
    
}
