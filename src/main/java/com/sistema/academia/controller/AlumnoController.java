package com.sistema.academia.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistema.academia.entities.Alumno;
import com.sistema.academia.entities.Distrito;
import com.sistema.academia.services.ALumnoServices;
import com.sistema.academia.services.DistritoServices;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

	@Autowired
	private ALumnoServices servicioAlu;
	
	@Autowired
	private DistritoServices servicioDis;
	
	@RequestMapping("/lista")
	public String index(Model model, @Param("palabraClave") String palabraClave) 
	{
		model.addAttribute("alumnos", servicioAlu.listarTodos(palabraClave));
		model.addAttribute("palabraClave", palabraClave);
		model.addAttribute("distritos", servicioDis.listaDistrito());
		
		return "alumno";
	}
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo") Integer cod,
						 @RequestParam("nombre") String nom,
						 @RequestParam("apellido") String ape,
						 @RequestParam("dni")String dni,
						 @RequestParam("fechaNac")String fechaNac,
						 @RequestParam("sexo")String sexo,
						 @RequestParam("distrito")int codDis,
						 @RequestParam("direccion")String direccion,
						 @RequestParam("estado")Boolean estado,						
						 RedirectAttributes redirect)
	{
		try {
			
			Alumno alu = new Alumno();
			
			alu.setNombre(nom);
			alu.setApellido(ape);
			alu.setDni(dni);
			alu.setFechanaci(LocalDate.parse(fechaNac));
			alu.setSexo(sexo);
			alu.setDireccion(direccion);
			alu.setEstado(estado);

			Distrito dis = new Distrito();
			
			dis.setCodigo(codDis);
			alu.setDistrito(dis);
			
			
			
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
	
		
}
	



