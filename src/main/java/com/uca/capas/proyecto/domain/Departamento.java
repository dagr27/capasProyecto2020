package com.uca.capas.proyecto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="departamento")
public class Departamento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_departamento")
	private Integer c_departamento;
	
	@Column(name="departamento")
	@NotEmpty(message="No puede estar vacio")
	@Size(max=30, message="No debe de tener mas de 50 caracteres")
	private String departamento;
<<<<<<< HEAD

	

	public Integer getC_departamento() {
		return c_departamento;
	}

	public void setC_departamento(Integer c_departamento) {
		this.c_departamento = c_departamento;
=======
	
	public Departamento() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
>>>>>>> e7e7aa6849585d51d1e4acbccf6370e67f0870c5
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
<<<<<<< HEAD
	
=======
>>>>>>> e7e7aa6849585d51d1e4acbccf6370e67f0870c5
}
