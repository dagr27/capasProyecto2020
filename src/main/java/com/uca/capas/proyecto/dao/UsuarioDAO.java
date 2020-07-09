package com.uca.capas.proyecto.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.proyecto.domain.Usuario;

public interface UsuarioDAO {

	public List<Usuario> findAll() throws DataAccessException;
	
	public void save(Usuario usuario) throws DataAccessException;
}
