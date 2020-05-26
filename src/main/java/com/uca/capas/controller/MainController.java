package com.uca.capas.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.CategoryDAO;
import com.uca.capas.dao.BookDAO;
import com.uca.capas.domain.Category;
import com.uca.capas.domain.Book;


@Controller
public class MainController {
	
	@Autowired
	private BookDAO Bookdao;
	
	@Autowired
	private CategoryDAO Categorydao;
	
	@RequestMapping("/index")
	public ModelAndView init() {
ModelAndView mav = new ModelAndView();
mav.setViewName("index");
		return mav;		
	}
	
	@RequestMapping("/lista")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		List<Book> libros =Bookdao.findAll(); 
		try {
			
			
			
			mav.addObject("libros", libros);
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		mav.setViewName("listadoLibros");
		return mav;
	}
	
	@GetMapping("/agregarCategorias")
	public ModelAndView inicio() {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("categoria", new Category());
		mav.setViewName("NewCategory");
		return mav;
	}
	
	@GetMapping("/agregarLibros")
	public ModelAndView inicio2() {
		ModelAndView mav = new ModelAndView();
		Book libro = new Book();
		mav.addObject("libro", libro);
		List<Category> categorias = null;
		
		categorias = Categorydao.findAll();
		mav.addObject("categoria", libro.getCategoria());
		mav.addObject("categorias", categorias);
		mav.setViewName("NewBook");
		return mav;
	}
	
	//SAVE
	@RequestMapping("/agregarL")
	public ModelAndView guardar(@Valid @ModelAttribute Book libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("NewBook");
		}
		else {
			Bookdao.save(libro);
			mav.setViewName("agregadoB");
		}	
		return mav;
	}
	
	@RequestMapping("/agregarC")
	public ModelAndView guardar(@Valid @ModelAttribute Category categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("NewCategory");
		}
		else {
			Categorydao.save(categoria);
			mav.setViewName("agregadoC");
		}	
		return mav;
	}
	
}
