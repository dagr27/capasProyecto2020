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
@Table(schema="public", name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_usuario")
	private Integer c_usuario;
	
	@Column(name="nombre")
	@NotEmpty(message="No puede estar vacio")
	@Size(max=30, message="No debe de tener mas de 50 caracteres")
	private String nombre;
	
	@Column(name="apellido")
	@NotEmpty(message="No puede estar vacio")
	@Size(max=30, message="No debe de tener mas de 50 caracteres")
	private String apellido;
	
	@Column(name="f_nacimiento")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date f_nacimiento;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_departamento")
	private Departamento c_departamento;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_municipio")
	private Municipio c_municipio;
	
	@Column(name="direccion")
	@NotEmpty(message="No puede estar vacio")
	@Size(max=30, message="No debe de tener mas de 50 caracteres")
	private String direccion;
	
	@Column(name="estado")
	private Boolean estado;
	
	@Column(name="usuario")
	@NotEmpty(message="No puede estar vacio")
	@Size(max=30, message="No debe de tener mas de 50 caracteres")
	private String usuario;
	
	@Column(name="password")
	private String password;
	
	@Column(name="tipo")
	@NotEmpty(message="No puede estar vacio")
	@Size(max=30, message="No debe de tener mas de 50 caracteres")
	private String tipo;
	
	public Usuario() {}

	public Integer getC_usuario() {
		return c_usuario;
	}

	public void setC_usuario(Integer c_usuario) {
		this.c_usuario = c_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public Departamento getC_departamento() {
		return c_departamento;
	}

	public void setC_departamento(Departamento c_departamento) {
		this.c_departamento = c_departamento;
	}

	public Municipio getC_municipio() {
		return c_municipio;
	}

	public void setC_municipio(Municipio c_municipio) {
		this.c_municipio = c_municipio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	
	
}
