package com.uca.capas.proyecto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.proyecto.domain.Municipio;

@Repository
public class MunicipioDAOImpl implements MunicipioDAO {
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Municipio> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.municipio");
		Query query = entityManager.createNativeQuery(sb.toString(), Municipio.class);
		List<Municipio> resultSet = query.getResultList();
		return resultSet;
	}

	@Override
	@Transactional
	public void save(Municipio municipio) throws DataAccessException {
		// TODO Auto-generated method stub
		entityManager.persist(municipio);
	}

}
