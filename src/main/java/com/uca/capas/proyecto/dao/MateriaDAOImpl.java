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
		sb.append("SELECT * FROM public.materia order by c_materia asc");
		Query query = entityManager.createNativeQuery(sb.toString(), Materia.class);
		List<Materia> resultSet = query.getResultList();
		return resultSet;
	}

	@Override
	@Transactional
	public void save(Materia materia) throws DataAccessException {
		entityManager.persist(materia);
		
	}

	@Override
	public Materia findById(Integer id) throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.materia WHERE c_materia= '"+id.toString()+"'");
		Query query = entityManager.createNativeQuery(sb.toString(), Materia.class);
		List<Materia> mat = query.getResultList();
		
		Materia materia = mat.get(0);
		return materia;
	}

	@Override
	@Transactional
	public void updateMat(Materia mat) throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE public.materia set nombre='"+mat.getNombre()+"', descripcion='"+mat.getDescripcion()+"'  WHERE c_materia= '"+mat.getC_materia().toString()+"'");
		Query query = entityManager.createNativeQuery(sb.toString(), Materia.class);
		query.executeUpdate();
	}

}
