package com.sistema.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.academia.services.DistritoServices;
import com.sistema.academia.services.NivelServices;
import com.sistema.academia.services.SeccionServices;

@Controller
@RequestMapping("/matricula")
public class MatriculaController {

	@Autowired
	private DistritoServices servicioDis;
	
	@Autowired
	private NivelServices servicioNivel;
	
	@Autowired
	private SeccionServices servicioSec;
	
	@RequestMapping("/lista")
	public String Index(Model model) {
		
		model.addAttribute("distritos", servicioDis.listaDistrito());
		model.addAttribute("niveles", servicioNivel.listarTodos());
		model.addAttribute("seccion", servicioSec.listarTodos());
		
		return "matricula";
	}
	
}
