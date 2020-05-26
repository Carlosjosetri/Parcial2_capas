package com.uca.capas.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Book;



public interface BookDAO {
	
	public List<Book> findAll() throws DataAccessException;
	
	@Transactional
	public void insert(Book book) throws DataAccessException;

}
