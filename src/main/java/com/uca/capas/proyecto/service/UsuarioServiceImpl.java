package com.uca.capas.proyecto.service;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.proyecto.dao.UsuarioDAO;
import com.uca.capas.proyecto.domain.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public List<Usuario> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return usuarioDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Usuario usuario) throws DataAccessException {
		// TODO Auto-generated method stub
		usuarioDAO.save(usuario);
	}

	@Override
	public Usuario validLogin(String usuario, String password) throws DataAccessException {
		// TODO Auto-generated method stub
		return usuarioDAO.validLogin(usuario, password);
	}

}
