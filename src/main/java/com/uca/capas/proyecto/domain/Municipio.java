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
	private Integer id;
	
	@Column(name="municipio")
	@NotEmpty(message="No puede estar vacio")
	@Size(max=30, message="No debe de tener mas de 50 caracteres")
	private String municipio;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_departamento")
	private Departamento c_departamento;

}
