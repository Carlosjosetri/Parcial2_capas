package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Book;
import com.uca.capas.domain.Category;

@Repository
public class CategoryDAOIMPL implements CategoryDAO {
	
	@PersistenceContext(unitName="Parcial2")
	public EntityManager entityManager;

	@Override
	public List<Category> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();

		sb.append("SELECT * FROM PUBLIC.cat_categoria;");
		Query query = entityManager.createNativeQuery(sb.toString(),Category.class);
		List <Category> result= query.getResultList();
		return result;
	}




	@Override
	public void insert(Category category) throws DataAccessException {
		entityManager.persist(category);
		
	}

}
