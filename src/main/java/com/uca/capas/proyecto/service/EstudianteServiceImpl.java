package com.uca.capas.proyecto.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.proyecto.dao.EstudianteDAO;
import com.uca.capas.proyecto.domain.Estudiante;


@Service
public class EstudianteServiceImpl implements EstudianteService {
	
	@Autowired
	private EstudianteDAO estudianteDao;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		return estudianteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Estudiante estudiante) throws DataAccessException {
		estudianteDao.save(estudiante);
		
	}

	
}
