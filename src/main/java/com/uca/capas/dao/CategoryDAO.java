package com.uca.capas.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Category;


public interface CategoryDAO {
	public List<Category> findAll() throws DataAccessException;
	
	@Transactional
	public void insert(Category category) throws DataAccessException;
}
