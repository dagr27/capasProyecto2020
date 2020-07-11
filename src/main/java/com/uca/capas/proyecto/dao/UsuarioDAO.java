package com.uca.capas.proyecto.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.proyecto.domain.Usuario;

public interface UsuarioDAO {

	public List<Usuario> findAll() throws DataAccessException;
	
	public Usuario findById(Integer id) throws DataAccessException;
	
	public void save(Usuario usuario) throws DataAccessException;
	
	public void uodate(Usuario usuario) throws DataAccessException;
	
	public Usuario validLogin(String usuario, String password) throws DataAccessException;
}
