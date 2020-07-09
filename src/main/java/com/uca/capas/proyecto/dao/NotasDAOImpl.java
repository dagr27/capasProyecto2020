package com.uca.capas.proyecto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.proyecto.domain.Notas;

@Repository
public class NotasDAOImpl implements NotasDAO {
	@PersistenceUnit(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Notas> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * public.materia_estudiante");
		Query query = entityManager.createNativeQuery(sb.toString(), Notas.class);
		List<Notas> resultSet = query.getResultList();
		return resultSet;
	}

	@Override
	@Transactional
	public void save(Notas nota) throws DataAccessException {
		entityManager.persist(nota);
		
	}

}
