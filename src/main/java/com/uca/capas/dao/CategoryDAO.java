package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Category;

public interface CategoryDAO {
	
	public List<Category> findAll() throws DataAccessException; 
	
	public Category findOne(Integer codigoCategoria) throws DataAccessException; 
	
	public void save(Category categoria) throws DataAccessException; 
	
	public void delete(Integer codigoCategoria) throws DataAccessException; 
	
}
