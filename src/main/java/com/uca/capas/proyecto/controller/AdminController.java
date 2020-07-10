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
import com.uca.capas.proyecto.domain.Departamento;
import com.uca.capas.proyecto.domain.Materia;
import com.uca.capas.proyecto.domain.Municipio;
import com.uca.capas.proyecto.domain.Usuario;
import com.uca.capas.proyecto.service.CentroEscolarService;
import com.uca.capas.proyecto.service.DepartamentoService;
import com.uca.capas.proyecto.service.MateriaService;
import com.uca.capas.proyecto.service.MunicipioService;
import com.uca.capas.proyecto.service.UsuarioService;

@Controller
public class AdminController {
	@Autowired
	private MateriaService materiaS;
	@Autowired
	private CentroEscolarService escuelaS;
	@Autowired
	private MunicipioService muniS;
	@Autowired
	private DepartamentoService dptoS;
	@Autowired
	private UsuarioService userS;
	
	private List<Materia> listMaterias= null;
	private List<CentroEscolar> listEscuelas= null;
	private List<Municipio> listMunicipio= null;
	private List<Departamento> listDpto = null;
	private List<Usuario> listUser = null;
	
	
	
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
	@RequestMapping("admin/users")
	public ModelAndView adminUsers() {
		ModelAndView mav = new ModelAndView();
		Usuario user = new Usuario();
		try {
			listDpto = dptoS.findAll();
			listMunicipio = muniS.findAll();
			listUser = userS.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("municipios", listMunicipio);
		mav.addObject("departamentos", listDpto);
		mav.addObject("listUser", listUser);
		mav.addObject("user", user);
		mav.setViewName("admin/users.html");
		return mav;
	}
	
	@RequestMapping("/saveUsers")
	public ModelAndView saveUsers(@Valid @ModelAttribute Usuario user, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		Usuario usu = new Usuario();
		if(result.hasErrors()) {
			try {
				listUser = userS.findAll();
			} catch(Exception e) {
				e.printStackTrace();
			}
			mav.setViewName("admin/users");
		}else {
			listUser = null;
			user.setEstado(true);
			user.setTipo("colab");
			user.setSesion(false);
			userS.save(user);
			try {
				listUser = userS.findAll();
			} catch(Exception e) {
				e.printStackTrace();
			}
			mav.addObject("listUser", listUser);
			mav.addObject("user",usu);
			mav.setViewName("admin/users");
		}
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
	
	@RequestMapping("admin/school")
	public ModelAndView escuelasScreen() {
		ModelAndView mav = new ModelAndView();
		CentroEscolar escuela = new CentroEscolar();
		try {
			listEscuelas = escuelaS.findAll();
			listMunicipio = muniS.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("listSchool", listEscuelas);
		mav.addObject("municipios", listMunicipio);
		mav.addObject("school", escuela);
		mav.setViewName("admin/school");
		return mav;
	}
	
	@RequestMapping("/saveEscuela")
	public ModelAndView saveEscuela(@Valid @ModelAttribute CentroEscolar escuela, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			try {
				listEscuelas = escuelaS.findAll();
			} catch(Exception e) {
				e.printStackTrace();
			}
			mav.setViewName("admin/school");
		}else {
			listEscuelas = null;
			listMunicipio = null;
			escuelaS.save(escuela);
			try {
				listEscuelas = escuelaS.findAll();
				listMunicipio = muniS.findAll();
			} catch(Exception e) {
				e.printStackTrace();
			}
			CentroEscolar school = new CentroEscolar();
			mav.addObject("school",school);
			mav.addObject("municipios", listMunicipio);
			mav.addObject("listSchool", listEscuelas);
			mav.setViewName("admin/school");
		}
		return mav;
	}
	
	
	


}
