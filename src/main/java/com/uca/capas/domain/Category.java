package com.uca.capas.domain;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="cat_categoria")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cat_categoria")
	private Integer codigoCategoria;
	
	@Column(name="s_categoria")
	private String nombreCategoria;
	
	@OneToMany(mappedBy="codigoCategoria", fetch=FetchType.EAGER)//SI NO FUNCIONA, CAMBIAR A CONTRIBUYENTE
	private List<Book> Books;
	
	

	
	
	public Integer getCodigoCategoria() {
		return codigoCategoria;
	}





	public void setCodigoCategoria(Integer codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}





	public String getNombreCategoria() {
		return nombreCategoria;
	}





	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}





	public List<Book> getBooks() {
		return Books;
	}





	public void setBooks(List<Book> books) {
		Books = books;
	}





	public Category() {}
	

}
