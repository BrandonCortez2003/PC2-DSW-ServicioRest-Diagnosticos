package com.sistema.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistema.academia.entities.Rol;
import com.sistema.academia.services.RolServices;

@Controller
@RequestMapping("rol")
public class RolController {

	@Autowired
	private RolServices servicioRol;
	
	@RequestMapping("/lista")
	public String Index(Model model) {
		model.addAttribute("roles", servicioRol.listarTodos());
		
		return "rol";
	}
	
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo") Integer cod,
						@RequestParam("descripcion") String nom,
						@RequestParam("tipo")Boolean tipo,
						RedirectAttributes redirect) 
	{
		try {
			
			Rol rol = new Rol();
			
			rol.setDescripcion(nom);
			rol.setRol(tipo);
			
			if(cod == 0) {
				servicioRol.registrar(rol);
				redirect.addFlashAttribute("MENSAJE","Rol Registrado");
			}
			else {
				rol.setCodigo(cod);
				servicioRol.actualizar(rol);
				redirect.addFlashAttribute("MENSAJE","Rol Actualizado");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/rol/lista";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Rol buscarRoles (@RequestParam("codigo") Integer cod) {
		return servicioRol.buscarPorID(cod);
	}
	
	@RequestMapping("/eliminar")
	public String elimnarPorCodigo(@RequestParam("codigo")Integer cod,
									RedirectAttributes redirect)
	{
		servicioRol.eliminarPorID(cod);
		redirect.addFlashAttribute("MENSAJE","Rol eliminado correctamente");
		
		return "redirect:/rol/lista";
	}
	
	
	
}
