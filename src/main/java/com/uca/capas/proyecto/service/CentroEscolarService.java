package com.uca.capas.proyecto.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.proyecto.domain.CentroEscolar;

public interface CentroEscolarService {
	public List<CentroEscolar> findAll() throws DataAccessException;
	
	public void save(CentroEscolar escuela) throws DataAccessException;
	
	public CentroEscolar findByid(Integer id) throws DataAccessException;
	
	public void updateCentro(CentroEscolar escuela) throws DataAccessException;
}
