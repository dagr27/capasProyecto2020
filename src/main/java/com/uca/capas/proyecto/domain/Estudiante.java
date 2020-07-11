package com.uca.capas.proyecto.domain;

import java.util.Date;

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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema="public", name="estudiante")
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_estudiante")	
	private Integer c_estudiante;
	
	@Column(name="nombres")
	@NotEmpty(message="No puede estar vacio")
	@Size(max=50, message="No debe de tener mas de 50 caracteres")
	private String nombres;
	
	@Column(name="apellido")
	@NotEmpty(message="No puede estar vacio")
	@Size(max=50, message="No debe de tener mas de 50 caracteres")
	private String apellido;
	
	@Column(name="f_nacimiento")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date f_nacimiento;
	
	@Column(name="direccion")
	@NotEmpty(message="No puede estar vacio")
	@Size(max=50, message="No debe de tener mas de 50 caracteres")
	private String direccion;
	
	@Column(name="celular")
	@NotEmpty(message="No puede estar vacio")
	@Size(max=50, message="No debe de tener mas de 10 caracteres")
	private String celular;
	
	@Column(name="telefono")
	@NotEmpty(message="El campo no puede estar vacio")
	@Size(max=50, message="No debe de tener mas de 10 caracteres")
	private String telefono;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_centro_escolar")
	private CentroEscolar c_centro_escolar;
	
	@Column(name="padre")
	@NotEmpty(message="El campo no puede estar vacio")
	@Size(max=50, message="No debe de tener mas de 50 caracteres")
	private String padre;
	
	@Column(name="madre")
	@NotEmpty(message="No puede estar vacio")
	@Size(max=50, message="No debe de tener mas de 50 caracteres")
	private String madre;
	
	@Column(name="carnet")
	@NotEmpty(message="No puede estar vacio")
	@Size(max=9, message="No debe de tener mas de 9 caracteres")
	private String carnet;
	
	
	
	public Estudiante() {}



	public Integer getC_estudiante() {
		return c_estudiante;
	}



	public void setC_estudiante(Integer c_estudiante) {
		this.c_estudiante = c_estudiante;
	}



	public String getNombres() {
		return nombres;
	}



	public void setNombres(String nombres) {
		this.nombres = nombres;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Date getF_nacimiento() {
		return f_nacimiento;
	}



	public void setF_nacimiento(Date f_nacimiento) {
		this.f_nacimiento = f_nacimiento;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getCelular() {
		return celular;
	}



	public void setCelular(String celular) {
		this.celular = celular;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public CentroEscolar getC_centro_escolar() {
		return c_centro_escolar;
	}



	public void setC_centro_escolar(CentroEscolar c_centro_escolar) {
		this.c_centro_escolar = c_centro_escolar;
	}



	public String getPadre() {
		return padre;
	}



	public void setPadre(String padre) {
		this.padre = padre;
	}



	public String getMadre() {
		return madre;
	}



	public void setMadre(String madre) {
		this.madre = madre;
	}
	
	public String getCarnet() {
		return carnet;
	}



	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	
	
	
}
