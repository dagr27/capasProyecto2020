package com.uca.capas.proyecto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.proyecto.domain.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Usuario> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.usuario");
		Query query = entityManager.createNativeQuery(sb.toString(), Usuario.class);
		List<Usuario> resultSet = query.getResultList();
		return resultSet;
	}

	@Override
	@Transactional
	public void save(Usuario usuario) throws DataAccessException {
		// TODO Auto-generated method stub)
		entityManager.persist(usuario);
	}

	@Override
	public Usuario validLogin(String usuario, String password) throws DataAccessException {
		// TODO Auto-generated method stub		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.usuario WHERE usuario = " + "'" + usuario + "'");
		
		Query query = entityManager.createNativeQuery(sb.toString(), Usuario.class);
		List<Usuario> usuarios = query.getResultList();
		if (usuarios == null || (usuarios != null && usuarios.size() == 0)) return null;
		
		Usuario user = usuarios.get(0);
		if (user != null && user.getEstado() && !user.getSesion() && user.getPassword().equals(password)) {
			// RETURN USER ROLE
			return user; 
		}
		
		return null;
	}

}
