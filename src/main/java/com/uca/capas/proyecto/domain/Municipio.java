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
@Table(schema="public", name="municipio")
public class Municipio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_municipio")
	private Integer c_municipio;
	
	@Column(name="municipio")
	@NotEmpty(message="No puede estar vacio")
	@Size(max=500, message="No debe de tener mas de 50 caracteres")
	private String municipio;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_departamento")
	private Departamento c_departamento;

	public Integer getC_municipio() {
		return c_municipio;
	}

	public void setC_municipio(Integer c_municipio) {
		this.c_municipio = c_municipio;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Departamento getC_departamento() {
		return c_departamento;
	}

	public void setC_departamento(Departamento c_departamento) {
		this.c_departamento = c_departamento;
	}
	
	

}
