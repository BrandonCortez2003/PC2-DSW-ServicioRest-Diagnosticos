package com.sistema.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.academia.services.ApoderadoServices;

@Controller
@RequestMapping("/apoderado")
public class ApoderadoController {

	@Autowired
	private ApoderadoServices servicioApo;
	
	@RequestMapping("/lista")
	public String index(Model model, @Param("palabraClave") String palabraClave) {
		
		
		model.addAttribute("apoderado",servicioApo.listarTodos(palabraClave));
		model.addAttribute("palabraClave", palabraClave);
		
		return "apoderado";
	
	}
	
	
}
