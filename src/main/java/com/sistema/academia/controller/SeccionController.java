package com.sistema.academia.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.sistema.academia.entities.Seccion;
import com.sistema.academia.services.SeccionServices;


@Controller
@RequestMapping("/seccion")
public class SeccionController {
	

	@Autowired
	private SeccionServices servicioSeccion;
	
	
	@RequestMapping("/lista")
	public String Index(Model model)
	{
		model.addAttribute("seccion", servicioSeccion.listarTodos());
		
		return "seccion2";
		
	}
	
	@RequestMapping("/grabar")
	public String grabar (@RequestParam("codigo") Integer cod,
			@RequestParam("descripcion") String des,
			@RequestParam("vacante") int vacante,
			@RequestParam("estado") Boolean es,
			RedirectAttributes redirect)
	{ 
		try 
		{
			Seccion sec = new Seccion();
			
			sec.setDescripSeccion(des);
			sec.setEstado(es);
			
			
			
			if(cod == 0)
			{
				servicioSeccion.registrar(sec);
				redirect.addFlashAttribute("MENSAJE","Seccion Registrado Correctamente");
			}
			else
			{
				sec.setCodigo(cod);
				servicioSeccion.actualizar(sec);
				redirect.addFlashAttribute("MENSAJE","Seccion Actualizado Correctamente");
			}
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "redirect:/seccion/lista";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Seccion buscar (@RequestParam("codigo") Integer cod)
	{
		return servicioSeccion.buscarPorID(cod);
	}

	@RequestMapping("/eliminar")
	public String eliminarPorCodigo(@RequestParam("codigo")Integer cod,
									RedirectAttributes redirect) 
	{
		servicioSeccion.eliminarPoID(cod);
		redirect.addFlashAttribute("MENSAJE","Seccion eliminado correctamente");
		
		return "redirect:/seccion/lista";
	}

}
