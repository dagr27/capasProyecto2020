package com.uca.capas.proyecto.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.proyecto.domain.CentroEscolar;
import com.uca.capas.proyecto.domain.Estudiante;
import com.uca.capas.proyecto.service.CentroEscolarService;
import com.uca.capas.proyecto.service.EstudianteService;

@Controller
public class ColabController {
	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private CentroEscolarService centroService;
	
	@RequestMapping("colab/home")
	public ModelAndView colabHome() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("colaborator/home");
		return mav;
	}
	
	@RequestMapping("colab/expediente")
	public ModelAndView expColab() {
		ModelAndView mav = new ModelAndView();	
		Estudiante estudiante = new Estudiante();
		List<CentroEscolar> centros = null;
		try {
				centros = centroService.findAll();
				
		}catch (Exception e) {
				e.printStackTrace();
			}
			
			mav.addObject("estudiante", estudiante);
			mav.addObject("centros",centros);
			mav.setViewName("colaborator/expediente");
			return mav;
	}
		
	
	@RequestMapping("/saveExp")
	public ModelAndView saveExp(@Valid @ModelAttribute Estudiante student, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = new Estudiante();
		List<CentroEscolar> centros = null;
		if(!result.hasErrors()) {
		try {
				estudianteService.save(student);
				centros = centroService.findAll();
				
		}catch (Exception e) {
				e.printStackTrace();
			}
			
			mav.addObject("estudiante", estudiante);
			mav.addObject("centros",centros);
			mav.setViewName("colaborator/expediente");
			}
		
		return mav;
	}
	
	@RequestMapping("colab/notas")
	public ModelAndView colabNotas() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("colaborator/notas");
		return mav;
	}
	
	
	
	
	
	
}
