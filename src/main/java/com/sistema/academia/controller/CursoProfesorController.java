package com.sistema.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.academia.services.CursoProfesorServices;
import com.sistema.academia.services.CursoServices;
import com.sistema.academia.services.ProfesorServices;

@Controller
@RequestMapping("/cursoprofesor")
public class CursoProfesorController {
	
	@Autowired
	private CursoProfesorServices servicioCursPro;
	
	
	@Autowired
	private CursoServices servicioCurs;
	
	@Autowired
	private ProfesorServices servicioProf;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		
		model.addAttribute("cursoProfesor",servicioCursPro.listarTodos());
		model.addAttribute("curso",servicioCurs.listarTodos());
		model.addAttribute("profesor",servicioProf.listarTodos());
		
		return "cursoProfesor";
	
	}
	

	
	

}
