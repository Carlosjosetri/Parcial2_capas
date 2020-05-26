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




@Transactional
@Controller
public class MainController {

;
	
	@GetMapping("/inicio")
	public ModelAndView init() {
		ModelAndView mav=new ModelAndView();
	
		mav.setViewName("index");
		return mav;		
	}
	
	
	
}
