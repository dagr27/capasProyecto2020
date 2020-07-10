package com.uca.capas.proyecto.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.proyecto.domain.Departamento;
import com.uca.capas.proyecto.domain.Municipio;
import com.uca.capas.proyecto.domain.Usuario;
import com.uca.capas.proyecto.service.DepartamentoService;
import com.uca.capas.proyecto.service.MunicipioService;
import com.uca.capas.proyecto.service.UsuarioService;

@Controller
public class loginController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private MunicipioService muniService;
	@Autowired
	private DepartamentoService depaService;
	
	
	@RequestMapping("/index")
	public ModelAndView index() {
		return login();
	}
	
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("usuario", new Usuario());
		mav.setViewName("index");
		
		List<Municipio> listMunicipios = new ArrayList<>();		
		List<Departamento> listDepartamentos = new ArrayList<>();

		try {
			listMunicipios = muniService.findAll();
			listDepartamentos = depaService.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("municipios", listMunicipios);
		mav.addObject("departamentos", listDepartamentos);
				
		return mav;
	}
	
	@RequestMapping("/iniciarSesion")
	public ModelAndView iniciarSesion(@RequestParam(value = "user") String user, @RequestParam(value = "pwd") String pwd) {
		ModelAndView mav = new ModelAndView();
		
		if (user.isEmpty() || pwd.isEmpty()) {
			return login();
		} else {
			Usuario usuario = usuarioService.validLogin(user, pwd);
			if (usuario == null) return login();
		
			String usuerRole = usuario.getTipo();
			
			// UPDATE USER SESSION
			usuario.setSesion(true);
			try {
				usuarioService.save(usuario);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			// REDIRECT USER
			if (usuerRole.equals("admin")) {
				mav.setViewName("admin/home");
			}
			
			if (usuerRole.equals("colab")) {
				mav.setViewName("colaborator/home");
			}	
		}
		
		return mav;
	}
	
	@RequestMapping("/registrate")
	public ModelAndView registrate(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult r) {
		ModelAndView mav = new ModelAndView();
		
		if (r.hasErrors()) {
			mav.setViewName("index");
		} else {
			usuario.setEstado(false);
			usuario.setTipo("colab");
			usuario.setSesion(false);
			
			try {
				usuarioService.save(usuario);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return login();
		}
		
		return mav;
	}
}
