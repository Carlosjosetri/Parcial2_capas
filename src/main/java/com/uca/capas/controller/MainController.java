package com.uca.capas.controller;


import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.BookDAO;
import com.uca.capas.dao.CategoryDAO;
import com.uca.capas.domain.Book;
import com.uca.capas.domain.Category;





@Transactional
@Controller
public class MainController {


	
	@Autowired
	private BookDAO BookDao;
	
	@Autowired
	private CategoryDAO CategoryDao;
	
	
	@RequestMapping("/index")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping("/agregarLibro")
	public ModelAndView init() {
		ModelAndView mav=new ModelAndView();
		Book libro = new Book();
		List<Category> categorias = CategoryDao.findAll();
		
		mav.addObject("libro", libro);
		mav.addObject("categorias", categorias);
		
		mav.setViewName("NewBook");
		return mav;		
	}
	
	@GetMapping("/agregarCategoria")
	public ModelAndView init2() {
		ModelAndView mav=new ModelAndView();
		Category categoria = new Category();

		mav.addObject("categoria", categoria);
		
		mav.setViewName("NewCategory");
		return mav;		
	}
	
	
	@PostMapping(value="/agregarB")
	public ModelAndView agregar(@ModelAttribute Book libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();		
		try {BookDao.insert(libro);
		mav.setViewName("agregado");
								
		}catch(Exception e) {
			e.printStackTrace();
		}				
		return mav;				
	}
	@PostMapping(value="/agregarC")
	public ModelAndView agregar(@ModelAttribute Category categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();		
		try {CategoryDao.insert(categoria);
				mav.setViewName("agregado");
								
		}catch(Exception e) {
			e.printStackTrace();
		}				
		return mav;				
	}
	
	@GetMapping(value="/VistaLibros")
	public ModelAndView showAll() {
		ModelAndView mav= new ModelAndView();
		
		List<Book> libros =null;
		try {
			libros=BookDao.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		mav.addObject("libros", libros);
		mav.setViewName("listado");
		
		return mav;		
		
	}
	
	
	
}
