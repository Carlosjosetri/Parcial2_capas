package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Category;
import com.uca.capas.domain.Book;

@Repository
public class BookDAOImpl implements BookDAO{

	@PersistenceContext(unitName = "capas")
	private EntityManager entityManager;
	
	@Override
	public List<Book> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.cat_libro");
		javax.persistence.Query q = entityManager.createNativeQuery(sb.toString(), Book.class);
		List<Book> resultset = q.getResultList();
		
		return resultset;
	}

	@Override
	public Book findOne(Integer codigoLibro) throws DataAccessException {
		// TODO Auto-generated method stub
		Book libro = entityManager.find(Book.class, codigoLibro);
		return libro;
	}

	@Override
	@Transactional
	public void save(Book libro) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			if(libro.getCodigoLibro() == null) {
				entityManager.persist(libro);
			}else {
				entityManager.merge(libro);
				entityManager.flush();
			}
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void delete(Integer codigoLibro) throws DataAccessException {
		// TODO Auto-generated method stub
		Book libro = entityManager.find(Book.class, codigoLibro);
		entityManager.remove(libro);
	}

}
