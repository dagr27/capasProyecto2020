package com.uca.capas.proyecto.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.proyecto.dao.CentroEscolarDAO;
import com.uca.capas.proyecto.domain.CentroEscolar;

@Service
public class CentroEscolarServiceImpl implements CentroEscolarService {

	@Autowired
	private CentroEscolarDAO centroDao;
	
	@Override
	public List<CentroEscolar> findAll() throws DataAccessException {
		return centroDao.findAll();
	}

	@Override
	@Transactional
	public void save(CentroEscolar escuela) throws DataAccessException {
		centroDao.save(escuela);
		
	}

}
