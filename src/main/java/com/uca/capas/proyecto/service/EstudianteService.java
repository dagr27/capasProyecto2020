package com.uca.capas.proyecto.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.proyecto.domain.Estudiante;

public interface EstudianteService {
	public List<Estudiante> findAll() throws DataAccessException;
	
	public void save(Estudiante estudiante) throws DataAccessException;
	
	
}
