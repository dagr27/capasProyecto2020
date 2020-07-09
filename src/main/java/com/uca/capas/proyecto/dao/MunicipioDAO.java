package com.uca.capas.proyecto.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.proyecto.domain.Municipio;


public interface MunicipioDAO {
	
	public List<Municipio> findAll() throws DataAccessException;
	
	public void save(Municipio municipio) throws DataAccessException;

}
