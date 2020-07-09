package com.uca.capas.proyecto.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.proyecto.dao.MateriaDAO;
import com.uca.capas.proyecto.domain.Materia;

@Service
public class MateriaServiceImpl implements MateriaService {
	@Autowired
	private MateriaDAO materiaDAO;
	
	@Override
	public List<Materia> findAll() throws DataAccessException {
		return materiaDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Materia materia) throws DataAccessException {
		materiaDAO.save(materia);
		
	}

}
