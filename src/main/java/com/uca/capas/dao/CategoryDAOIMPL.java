package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Category;

@Repository
public class CategoryDAOIMPL implements CategoryDAO {

	@PersistenceContext(unitName = "capas")
	private EntityManager entityManager;
	
	@Override
	public List<Category> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.cat_categoria");
		javax.persistence.Query q = entityManager.createNativeQuery(sb.toString(), Category.class);
		List<Category> resultset = q.getResultList();
		
		return resultset;
	}

	@Override
	public Category findOne(Integer codigoCategoria) throws DataAccessException {
		// TODO Auto-generated method stub
		Category categoria = entityManager.find(Category.class, codigoCategoria);
		return categoria;
	}

	@Override
	@Transactional
	public void save(Category categoria) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			if(categoria.getCodigoCategoria() == null) {
				entityManager.persist(categoria);
			}else {
				entityManager.merge(categoria);
				entityManager.flush();
			}
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void delete(Integer codigoCategoria) throws DataAccessException {
		// TODO Auto-generated method stub
		Category categoria = entityManager.find(Category.class, codigoCategoria);
		entityManager.remove(categoria);
	}

}
