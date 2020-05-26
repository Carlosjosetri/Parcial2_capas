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

		sb.append("SELECT C.c_contribuyente,C.c_importancia,C.s_nombre,C.s_apellido,C.s_nit,C.f_fecha_ingreso\n" + 
				"FROM contribuyente C INNER JOIN importancia I \n" + 
				"ON C.c_importancia=I.c_importancia;");
		Query query = entityManager.createNativeQuery(sb.toString(),Book.class);
		List <Book> result= query.getResultList();
		return result;
	}


	@Override
	public void insert(Book book) throws DataAccessException {
		entityManager.persist(book);
		
	}

}