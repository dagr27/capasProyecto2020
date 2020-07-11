package com.uca.capas.proyecto.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.proyecto.domain.CentroEscolar;
import com.uca.capas.proyecto.domain.Estudiante;
import com.uca.capas.proyecto.domain.Materia;
import com.uca.capas.proyecto.domain.Notas;
import com.uca.capas.proyecto.service.CentroEscolarService;
import com.uca.capas.proyecto.service.EstudianteService;
import com.uca.capas.proyecto.service.MateriaService;
import com.uca.capas.proyecto.service.NotasService;

@Controller
public class ColabController {
	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private CentroEscolarService centroService;
	
	@Autowired
	private MateriaService materiaService;
	
	@Autowired
	private NotasService notasService;
	
	@RequestMapping("colab/home")
	public ModelAndView colabHome() {
		ModelAndView mav = new ModelAndView();
		List<Notas> notasList = null;
		try {
			notasList = notasService.findAll();
			mav.addObject("notasList",notasList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			mav.addObject("redireccionar", "Regresar");
			mav.setViewName("colaborator/expediente");
			}
		
		return mav;
	}
	
	@RequestMapping("colab/materias")
	public ModelAndView colabMaterias() {
		ModelAndView mav = new ModelAndView();
		Notas nota = new Notas();
		List<Materia> materias = null;
		List<Estudiante> estudiantes = null;
		try {
				materias = materiaService.findAll();
				estudiantes = estudianteService.findAll();
				
		}catch (Exception e) {
				e.printStackTrace();
			}
			
			mav.addObject("estudiantes", estudiantes);
			mav.addObject("materias",materias);
			mav.addObject("notas",nota);
			mav.setViewName("colaborator/materias");
			return mav;
	}
	
	@RequestMapping("/saveMat")
	public ModelAndView saveMateria(@Valid @ModelAttribute Notas note, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		Notas nota = new Notas();
		List<Materia> materias = null;
		List<Estudiante> estudiantes = null;
		if(!result.hasErrors()) {
		try {
				notasService.save(note);
				materias = materiaService.findAll();
				estudiantes = estudianteService.findAll();
				
		}catch (Exception e) {
				e.printStackTrace();
			}
			
			mav.addObject("notas", nota);
			mav.addObject("estudiantes", estudiantes);
			mav.addObject("materias",materias);
			mav.setViewName("colaborator/materias");
			}
		
		return mav;
	}
		
	@RequestMapping("colab/notas")
	public ModelAndView colabNotas() {
		ModelAndView mav = new ModelAndView();
		List<Notas> notasList = null;
		try {
			notasList = notasService.findAll();
			mav.addObject("notasList",notasList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("nombre","");
		mav.setViewName("colaborator/notas");
		return mav;
	}
	
	@PostMapping("/filtrar")
	public ModelAndView colabFiltrar(@RequestParam(value="nombre") String nombre) {
		ModelAndView mav = new ModelAndView();
		List<Notas> notasList = null;
		try {
			notasList = notasService.findAllByName(nombre);
			mav.addObject("notasList",notasList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mav.setViewName("colaborator/notas");
		return mav;
	}
	

	@RequestMapping("/editNotas")
	public ModelAndView editMateria(@RequestParam(value="c_notas") int c_nota) {
		ModelAndView mav = new ModelAndView();
		Notas notas = null;
		notas = notasService.findById(c_nota);
		mav.addObject("notaUp", notas);
		mav.setViewName("colaborator/editNota");
		return mav;
	}
	
	@PostMapping("/updateNotas")
	public ModelAndView updateMateria(@Valid @ModelAttribute Notas note, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		Notas nota = new Notas();
		List<Notas> notasList = null;
		if(result.hasErrors()) {
			try {
				notasList = notasService.findAll();
			} catch(Exception e) {
				e.printStackTrace();
			}
			mav.setViewName("colaborator/notas");
		}else {
			notasList = null;
			try {
				notasService.updateNota(note);
				notasList = notasService.findAll();
			} catch(Exception e) {
				e.printStackTrace();
			}
			mav.addObject("notas", nota);
			mav.addObject("redireccionar", "Regresar");
			mav.addObject("notasList", notasList);
			mav.setViewName("colaborator/notas");
		}
		return mav;
	}
}
