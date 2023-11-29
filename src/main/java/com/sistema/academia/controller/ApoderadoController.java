package com.sistema.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistema.academia.entities.Apoderado;
import com.sistema.academia.entities.Profesor;
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
	
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Apoderado buscarApoderado (@RequestParam("codigo") Integer cod)
	{
		return servicioApo.buscarPorID(cod);
	}

	@RequestMapping("/eliminar")
	public String eliminarPorCodigo(@RequestParam("codigo")Integer cod,
									RedirectAttributes redirect) 
	{
		servicioApo.eliminarPorID(cod);
		redirect.addFlashAttribute("MENSAJE","Apoderado eliminado correctamente");
		
		return "redirect:/apoderado/lista";
	}
	
	
}
