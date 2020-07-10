package com.uca.capas.proyecto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.proyecto.domain.CentroEscolar;

@Repository
public class CentroEscolarDAOImpl implements CentroEscolarDAO {
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<CentroEscolar> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * public.centro_escolar");
		Query query = entityManager.createNativeQuery(sb.toString(),CentroEscolar.class);	
		List<CentroEscolar> resultSet = query.getResultList();
		return resultSet;
	}
	
	@Override
	@Transactional
	public void save(CentroEscolar escuela) throws DataAccessException {
		entityManager.persist(escuela);
		
	}

}
