package com.sistema.academia.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistema.academia.entities.Distrito;
import com.sistema.academia.entities.Profesor;
import com.sistema.academia.repository.ProfesorRepository;
import com.sistema.academia.services.DistritoServices;
import com.sistema.academia.services.ProfesorServices;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {
	
	
	@Autowired
	private ProfesorServices servicioPro;
	
	@Autowired
	private DistritoServices servicioDis;
	
	
	@RequestMapping("/lista")
	public String index(Model model, @Param("palabraClave") String palabraClave) {
		
		
		model.addAttribute("profesor",servicioPro.listarTodos(palabraClave));
		model.addAttribute("palabraClave", palabraClave);
		model.addAttribute("distritos", servicioDis.listaDistrito());
		
		
		return "profesor";
	
	}
	

	
	@RequestMapping("/grabar")
	public String grabar (@RequestParam("codigo") Integer cod,
						@RequestParam("nombre")String nom,
						@RequestParam("apellido")String ape,
						@RequestParam("dni")String dni,
						@RequestParam("sexo")String sexo,
						@RequestParam("grado")String grado,
						@RequestParam("fechaNac")String fechaNac,
						@RequestParam("distrito")int codDis,
						@RequestParam("direccion")String direc,
						@RequestParam("mail")String correo,
						@RequestParam("fono")String fono,
						 @RequestParam("estado")Boolean estado,		
						
						
						RedirectAttributes redirect)
	{
		
		try {
			//crear objeto de la entidad medicamento
			Profesor pro = new Profesor();
			//setear atrinutos 
			pro.setNombre(nom);
			pro.setApellido(ape);
			pro.setDni(dni);
			pro.setSexo(sexo);
			pro.setGradoStudio(grado);
			pro.setFecNacimiento(LocalDate.parse(fechaNac));
			pro.setDireccion(direc);
			pro.setCorreo(correo);
			pro.setFono(fono);
			pro.setEstado(estado);
			
			Distrito dis = new Distrito();
			
			dis.setCodigo(codDis);
			pro.setDistrito(dis);
		

			
			//validar parametro
		
			if(cod == 0) {
				
				//Invocar metodo registrar
				servicioPro.registrar(pro);
				//crearatribut de tipo flash
				redirect.addFlashAttribute("MENSAJE","Medico registrado");
			}
			else {
				
				pro.setCodigo(cod);
				servicioPro.actualizar(pro);
				redirect.addFlashAttribute("MENSAJE","Medico actualizado");
			}
					
			

			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return "redirect:/profesor/lista";
		}

@RequestMapping("/buscar")
@ResponseBody
public Profesor buscarProfesor (@RequestParam("codigo") Integer cod)
{
	return servicioPro.buscarPorID(cod);
}

@RequestMapping("/eliminar")
public String eliminarPorCodigo(@RequestParam("codigo")Integer cod,
								RedirectAttributes redirect) 
{
	servicioPro.eliminarPorID(cod);
	redirect.addFlashAttribute("MENSAJE","Profesor eliminado correctamente");
	
	return "redirect:/profesor/lista";
}
		
		

}
