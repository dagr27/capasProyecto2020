package com.uca.capas.proyecto.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.proyecto.dao.MunicipioDAO;
import com.uca.capas.proyecto.domain.Municipio;

@Service
public class MunicipioServiceImpl implements MunicipioService {
	@Autowired
	private MunicipioDAO municipioDAO;
	
	@Override
	public List<Municipio> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return municipioDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Municipio municipio) throws DataAccessException {
		// TODO Auto-generated method stub
		municipioDAO.save(municipio);
	}

}
