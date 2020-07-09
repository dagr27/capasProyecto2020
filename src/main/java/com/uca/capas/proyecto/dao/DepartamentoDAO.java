package com.uca.capas.proyecto.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.proyecto.domain.Departamento;


public interface DepartamentoDAO {
	
	public List<Departamento> findAll() throws DataAccessException;
	
	public void save(Departamento departamento) throws DataAccessException;

}
