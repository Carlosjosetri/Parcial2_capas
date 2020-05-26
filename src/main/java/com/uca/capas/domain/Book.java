package com.uca.capas.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="cat_libro")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_libro")
	private Integer codigoLibro;
	

	@JoinColumn(name="c_categoria")
	@ManyToOne(fetch=FetchType.EAGER)
	Category codigoCategoria;
	
	@Column(name="s_titulo")
	private String nombreContribuyente;
	
	@Column(name="s_isbn")
	private String isbn;
	
	@Column(name="s_autor ")
	private String apellidoContribuyente;
	
	@Column(name="b_estado")
	private Boolean nitContribuyente;
	
	@Column(name="f_ingreso")
	private Date fechaIngreso;
	
	public Book() {}

	public Integer getCodigoLibro() {
		return codigoLibro;
	}

	public void setCodigoLibro(Integer codigoLibro) {
		this.codigoLibro = codigoLibro;
	}

	public Category getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(Category codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public String getNombreContribuyente() {
		return nombreContribuyente;
	}

	public void setNombreContribuyente(String nombreContribuyente) {
		this.nombreContribuyente = nombreContribuyente;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getApellidoContribuyente() {
		return apellidoContribuyente;
	}

	public void setApellidoContribuyente(String apellidoContribuyente) {
		this.apellidoContribuyente = apellidoContribuyente;
	}

	public Boolean getNitContribuyente() {
		return nitContribuyente;
	}

	public void setNitContribuyente(Boolean nitContribuyente) {
		this.nitContribuyente = nitContribuyente;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	
}
