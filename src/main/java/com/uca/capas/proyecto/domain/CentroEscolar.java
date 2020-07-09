package com.uca.capas.proyecto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="centro_escolar")
public class CentroEscolar {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_centro_escolar")
	private Integer c_centro_escolar;
	
	@Column(name="nombre")
	@NotEmpty(message="No puede estar vacio")
	@Size(max=30, message="No debe de tener mas de 50 caracteres")
	private String nombre;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_municipio")
	private Municipio c_municipio;
	
	public CentroEscolar() {}

	public Integer getC_centro_escolar() {
		return c_centro_escolar;
	}

	public void setC_centro_escolar(Integer c_centro_escolar) {
		this.c_centro_escolar = c_centro_escolar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Municipio getC_municipio() {
		return c_municipio;
	}

	public void setC_municipio(Municipio c_municipio) {
		this.c_municipio = c_municipio;
	}

	

	
	
}
