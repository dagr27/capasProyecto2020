package com.uca.capas.proyecto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.proyecto.domain.Materia;
import com.uca.capas.proyecto.domain.Notas;

@Repository
public class NotasDAOImpl implements NotasDAO {
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Notas> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from materia_estudiante");
		Query query = entityManager.createNativeQuery(sb.toString(), Notas.class);
		List<Notas> resultSet = query.getResultList();
		return resultSet;
	}

	@Override
	@Transactional
	public void save(Notas nota) throws DataAccessException {
		entityManager.persist(nota);
		
	}

	@Override
	public List<Notas> findAllByName(String name) throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select mat.* from materia_estudiante mat, estudiante e where e.c_estudiante = mat.c_estudiante AND e.nombres like '%"+name+"%'");
		Query query = entityManager.createNativeQuery(sb.toString(), Notas.class);
		List<Notas> resultSet = query.getResultList();
		return resultSet;
	}
	
	@Override
	public Notas findById(Integer id) throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.materia_estudiante WHERE c_materia_estudiante= '"+id.toString()+"'");
		Query query = entityManager.createNativeQuery(sb.toString(), Notas.class);
		List<Notas> not = query.getResultList();
		
		Notas nota = not.get(0);
		return nota;
	}


	@Override
	@Transactional
	public void updateNota(Notas nota) throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE public.materia_estudiante set nota='"+nota.getNota()+"'WHERE c_materia_estudiante= '"+nota.getC_materia_estudiante().toString()+"'");
		Query query = entityManager.createNativeQuery(sb.toString(), Notas.class);
		query.executeUpdate();
	}

	
}
