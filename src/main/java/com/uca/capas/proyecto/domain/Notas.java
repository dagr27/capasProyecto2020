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

@Entity
@Table(schema="public", name="materia_estudiante")
public class Notas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_materia_estudiante")
	private Integer c_materia_estudiante;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_materia")
	private Materia c_materia;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_estudiante")
	private Estudiante c_estudiante;
	
	@Column(name="nota")
	private Integer nota;
	
	@Column(name="anio")
	private Integer anio;
	
	@Column(name="ciclo")
	private Integer ciclo;
	
	public Notas() {}

	public Integer getC_materia_estudiante() {
		return c_materia_estudiante;
	}

	public void setC_materia_estudiante(Integer c_materia_estudiante) {
		this.c_materia_estudiante = c_materia_estudiante;
	}

	public Materia getC_materia() {
		return c_materia;
	}

	public void setC_materia(Materia c_materia) {
		this.c_materia = c_materia;
	}

	public Estudiante getC_estudiante() {
		return c_estudiante;
	}

	public void setC_estudiante(Estudiante c_estudiante) {
		this.c_estudiante = c_estudiante;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getCiclo() {
		return ciclo;
	}

	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}

	
	
	

}
