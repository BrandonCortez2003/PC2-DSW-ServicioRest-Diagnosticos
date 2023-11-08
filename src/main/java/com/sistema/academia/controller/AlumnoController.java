package com.sistema.academia.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistema.academia.entities.Alumno;
import com.sistema.academia.services.ALumnoServices;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

	@Autowired
	private ALumnoServices servicioAlu;
	
	@RequestMapping("/lista")
	public String Index(Model  model)
	{
		model.addAttribute("alumnos", servicioAlu.listarTodos());
		
		return "alumno";
	}
	
	/*@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo") Integer cod,
						 @RequestParam("nombre") String nom,
						 @RequestParam("apellido") String ape,
						 @RequestParam("edad")String edad,
						 @RequestParam("estado")String estado,
						 @RequestParam("dni")String dni,
						 @RequestParam("telefono")String fono,
						 @RequestParam("direccion")String direccion,
						 @RequestParam("correo")String correo,
						 @RequestParam("fehanaci")String fechanaci,
						 @RequestParam("fecharegi")String fecharegi,
						 RedirectAttributes redirect)
	{
		try {
			
			Alumno alu = new Alumno();
			
			alu.setNombre(nom);
			alu.setApellido(ape);
			alu.setEdad(edad);
			alu.setEstado(estado);
			alu.setDni(dni);
			alu.setTelefono(fono);
			alu.setDireccion(direccion);
			alu.setCorreo(correo);
			alu.setFechanaci(LocalDate.parse(fechanaci));
			alu.setFecharegi(LocalDate.parse(fecharegi));
			
			if(cod == 0)
			{
				servicioAlu.registrar(alu);
				redirect.addFlashAttribute("MENSAJE","Alummno Registrado Correctamente");
			}
			else
			{
				alu.setCodigo(cod);
				servicioAlu.actualizar(alu);
				redirect.addFlashAttribute("MENSAJE", "Alumnno actualizado correctamente");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/alumno/lista";
	}
	
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Alumno buscar (@RequestParam("codigo") Integer cod)
	{
		return servicioAlu.buscarPorID(cod);
	}

	@RequestMapping("/eliminar")
	public String eliminarPorCodigo(@RequestParam("codigo")Integer cod,
									RedirectAttributes redirect) 
	{
		servicioAlu.eliminarPorID(cod);
		redirect.addFlashAttribute("MENSAJE","Curso eliminado correctamente");
		
		return "redirect:/alumno/lista";
	}
	
		*/
}
	



