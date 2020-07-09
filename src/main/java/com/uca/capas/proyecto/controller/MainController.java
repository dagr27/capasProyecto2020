package com.uca.capas.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("admin/home")
	public ModelAndView adminHome() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/home.html");
		return mav;
	}
	
	@RequestMapping("admin/materias")
	public ModelAndView materiasScreen() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/materias");
		return mav;
	}
	
	@RequestMapping("colab/home")
	public ModelAndView colabHome() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("colaborator/home.html");
		return mav;
	}
	


}
