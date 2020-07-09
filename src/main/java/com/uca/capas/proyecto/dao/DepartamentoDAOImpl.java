package com.uca.capas.proyecto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.proyecto.domain.Departamento;


@Repository
public class DepartamentoDAOImpl implements DepartamentoDAO {
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Departamento> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.departamento");
		Query query = entityManager.createNativeQuery(sb.toString(), Departamento.class);
		List<Departamento> resultSet = query.getResultList();
		return resultSet;
	}

	@Override
	@Transactional
	public void save(Departamento departamento) throws DataAccessException {
		// TODO Auto-generated method stub
		entityManager.persist(departamento);
	}

}
