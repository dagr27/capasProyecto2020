package com.uca.capas.proyecto.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.proyecto.domain.Materia;

public interface MateriaService {
	public List<Materia> findAll() throws DataAccessException;
	
	public void save(Materia materia) throws DataAccessException;
	
	public Materia findById(Integer id) throws DataAccessException;
	
	public void updateMat(Materia mat) throws DataAccessException;

}
