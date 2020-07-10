package com.uca.capas.proyecto.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.proyecto.domain.Notas;

public interface NotasDAO {
	public List<Notas> findAll() throws DataAccessException;
	
	public List<Notas> findAllByName(String name) throws DataAccessException;
	
	public void save(Notas nota) throws DataAccessException;
}
