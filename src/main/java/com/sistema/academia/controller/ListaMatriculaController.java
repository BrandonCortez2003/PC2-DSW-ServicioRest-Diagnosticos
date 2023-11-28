package com.sistema.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistema.academia.entities.Matricula;
import com.sistema.academia.entities.Profesor;
import com.sistema.academia.services.MatriculaServices;

@Controller
@RequestMapping("/listaMatricula")
public class ListaMatriculaController {
	
	@Autowired
	private MatriculaServices servicioMat;
	
	@RequestMapping("/lista")
	public String Index(Model model) {
		
		model.addAttribute("matricula", servicioMat.listarTodos());
		
		return "listaMatricula";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Matricula buscarMatricula (@RequestParam("codigo") Integer cod)
	{
		return servicioMat.buscarPorID(cod);
	}

	@RequestMapping("/eliminar")
	public String eliminarPorCodigo(@RequestParam("codigo")Integer cod,
									RedirectAttributes redirect) 
	{
		servicioMat.eliminarPorID(cod);
		redirect.addFlashAttribute("MENSAJE","Matricula eliminada correctamente");
		
		return "redirect:/listaMatricula/lista";
	}

}
