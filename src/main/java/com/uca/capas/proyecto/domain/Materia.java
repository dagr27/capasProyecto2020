package com.uca.capas.proyecto.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="materia")
public class Materia {
	
	@Id
	@Column(name="c_materia")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer c_materia;
	
	@Column(name="nombre")
	@NotEmpty(message="No puede estar vacio")
	@Size(max=30, message="No debe de tener mas de 50 caracteres")
	private String nombre;
	
	@Column(name="descripcion")
	@NotEmpty(message="No puede estar vacio")
	@Size(max=500, message="No debe de tener mas de 50 caracteres")
	private String descripcion;
	
	public Materia() {}

	public Integer getC_materia() {
		return c_materia;
	}

	public void setC_materia(Integer c_materia) {
		this.c_materia = c_materia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	

	
}
