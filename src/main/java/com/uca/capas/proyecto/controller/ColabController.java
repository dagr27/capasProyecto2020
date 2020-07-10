package com.uca.capas.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ColabController {
	@RequestMapping("colab/home")
	public ModelAndView colabHome() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("colaborator/home.html");
		return mav;
	}
}
