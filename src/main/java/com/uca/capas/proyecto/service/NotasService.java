package com.uca.capas.proyecto.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.proyecto.domain.Notas;

public interface NotasService {
	public List<Notas> findAll() throws DataAccessException;
	
	public void save(Notas nota) throws DataAccessException;
}
