package com.uca.capas.proyecto.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.proyecto.domain.Departamento;

public interface DepartamentoService {
	
	public List<Departamento> findAll() throws DataAccessException;
	
	public void save(Departamento departamento) throws DataAccessException;

}
