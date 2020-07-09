package com.uca.capas.proyecto.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.proyecto.dao.DepartamentoDAO;
import com.uca.capas.proyecto.domain.Departamento;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
	@Autowired
	private DepartamentoDAO departamentoDAO;
	
	@Override
	public List<Departamento> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return departamentoDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Departamento departamento) throws DataAccessException {
		// TODO Auto-generated method stub
		departamentoDAO.save(departamento);
	}

}
