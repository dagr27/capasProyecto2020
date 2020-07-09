package com.uca.capas.proyecto.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.proyecto.domain.Materia;

@Repository
public class MateriaDAOImpl implements MateriaDAO {
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Materia> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.materia");
		Query query = entityManager.createNativeQuery(sb.toString(), Materia.class);
		List<Materia> resultSet = query.getResultList();
		return resultSet;
	}

	@Override
	@Transactional
	public void save(Materia materia) throws DataAccessException {
		entityManager.persist(materia);
		
	}

}
