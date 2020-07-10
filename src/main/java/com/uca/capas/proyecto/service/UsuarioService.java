package com.uca.capas.proyecto.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.proyecto.domain.Usuario;

public interface UsuarioService {
	
	public List<Usuario> findAll() throws DataAccessException;
	
	public void save(Usuario usuario) throws DataAccessException;
	
	public Usuario validLogin(String usuario, String password) throws DataAccessException;

}
