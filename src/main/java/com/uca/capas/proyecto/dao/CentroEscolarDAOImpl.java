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
		sb.append("SELECT * from public.centro_escolar order by c_centro_escolar asc");
		Query query = entityManager.createNativeQuery(sb.toString(),CentroEscolar.class);	
		List<CentroEscolar> resultSet = query.getResultList();
		return resultSet;
	}
	
	@Override
	@Transactional
	public void save(CentroEscolar escuela) throws DataAccessException {
		entityManager.persist(escuela);
		
	}

	@Override
	public CentroEscolar findByid(Integer id) throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.centro_escolar WHERE c_centro_escolar= '"+id.toString()+"'");
		Query query = entityManager.createNativeQuery(sb.toString(), CentroEscolar.class);
		List<CentroEscolar> ce = query.getResultList();
		
		CentroEscolar centro = ce.get(0);
		return centro;
	}

	@Override
	@Transactional
	public void updateCentro(CentroEscolar escuela) throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE public.centro_escolar set nombre='"+escuela.getNombre()+"'  WHERE c_centro_escolar= '"+escuela.getC_centro_escolar().toString()+"'");
		Query query = entityManager.createNativeQuery(sb.toString(), CentroEscolar.class);
		query.executeUpdate();
		
	}

}
