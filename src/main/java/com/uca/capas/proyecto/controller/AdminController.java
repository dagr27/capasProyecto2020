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
import com.uca.capas.proyecto.domain.Materia;
import com.uca.capas.proyecto.domain.Municipio;
import com.uca.capas.proyecto.service.CentroEscolarService;
import com.uca.capas.proyecto.service.MateriaService;
import com.uca.capas.proyecto.service.MunicipioService;

@Controller
public class AdminController {
	@Autowired
	private MateriaService materiaS;
	@Autowired
	private CentroEscolarService escuelaS;
	@Autowired
	private MunicipioService muniS;
	
	private List<Materia> listMaterias= null;
	private List<CentroEscolar> listEscuelas= null;
	private List<Municipio> listMunicipio= null;
	
	
	
	@RequestMapping("admin/home")
	public ModelAndView adminHome() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/home.html");
		return mav;
	}
	
	@RequestMapping("admin/materias")
	public ModelAndView materiasScreen() {
		ModelAndView mav = new ModelAndView();
		Materia materia = new Materia();
		try {
			listMaterias = materiaS.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("listMaterias", listMaterias);
		mav.addObject("materia", materia);
		mav.setViewName("admin/materias");
		return mav;
	}
	
	@RequestMapping("/saveMateria")
	public ModelAndView saveMateria(@Valid @ModelAttribute Materia materia, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			try {
				listMaterias = materiaS.findAll();
			} catch(Exception e) {
				e.printStackTrace();
			}
			mav.setViewName("admin/materias");
		}else {
			listMaterias = null;
			materiaS.save(materia);
			try {
				listMaterias = materiaS.findAll();
			} catch(Exception e) {
				e.printStackTrace();
			}
			mav.addObject("listMaterias", listMaterias);
			mav.setViewName("admin/materias");
		}
		return mav;
	}
	
	@RequestMapping("admin/escuelas")
	public ModelAndView escuelasScreen() {
		ModelAndView mav = new ModelAndView();
		try {
			listMunicipio = muniS.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("municipios", listMunicipio);
		mav.setViewName("admin/school");
		return mav;
	}
	
	
	


}
