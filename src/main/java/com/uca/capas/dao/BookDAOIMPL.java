package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Book;
;

@Repository
public class BookDAOIMPL implements BookDAO {
	
	@PersistenceContext(unitName="Parcial2")
	public EntityManager entityManager;

	@Override
	public List<Book> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();

		sb.append("SELECT * FROM PUBLIC.cat_libro;");
		Query query = entityManager.createNativeQuery(sb.toString(),Book.class);
		List <Book> result= query.getResultList();
		return result;
	}


	@Override
	public void insert(Book book) throws DataAccessException {
		entityManager.persist(book);
		
	}

}