package com.uca.capas.proyecto.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.proyecto.dao.NotasDAO;
import com.uca.capas.proyecto.domain.Notas;

@Service
public class NotasServiceImpl implements NotasService {
	@Autowired
	private NotasDAO notasDao;

	@Override
	public List<Notas> findAll() throws DataAccessException {
		return notasDao.findAll();
	}

	@Override
	@Transactional
	public void save(Notas nota) throws DataAccessException {
		notasDao.save(nota);
		
	}

	@Override
	public List<Notas> findAllByName(String name) throws DataAccessException {
		return notasDao.findAllByName(name);
	}
	
}
