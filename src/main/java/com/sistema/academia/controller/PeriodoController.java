package com.sistema.academia.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.sistema.academia.entities.Periodo;
import com.sistema.academia.services.PeriodoServices;

@Controller
@RequestMapping("/periodos")
public class PeriodoController {
	
	@Autowired
	private PeriodoServices servicioPeriodo;
	
	
	@RequestMapping("/lista")
	public String Index(Model model)
	{
		model.addAttribute("periodo", servicioPeriodo.listarTodos());
		
		return "periodos";
		
	}
	
@RequestMapping("/grabar")
public String grabar (@RequestParam("codigo") Integer cod,
		@RequestParam("descripcion") String des,
		@RequestParam("fechaIni") String fecini,
		@RequestParam("fechaFin") String fecfin,
		@RequestParam("estado") Boolean es,
		RedirectAttributes redirect)
{ 
	try 
	{
		Periodo per = new Periodo();
		
		per.setDescripcion(des);
		per.setFechaIni(LocalDate.parse(fecini));
		per.setFechafin(LocalDate.parse(fecfin));
		per.setEstado(es);
		
		
		
		if(cod == 0)
		{
			servicioPeriodo.registrar(per);
			redirect.addFlashAttribute("MENSAJE","Periodo Registrado Correctamente");
		}
		else
		{
			per.setCodigo(cod);
			servicioPeriodo.actualizar(per);
			redirect.addFlashAttribute("MENSAJE","Periodo Actualizado Correctamente");
		}
		
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return "redirect:/periodos/lista";
}

@RequestMapping("/buscar")
@ResponseBody
public Periodo buscar (@RequestParam("codigo") Integer cod)
{
	return servicioPeriodo.buscarPorID(cod);
}

@RequestMapping("/eliminar")
public String eliminarPorCodigo(@RequestParam("codigo")Integer cod,
								RedirectAttributes redirect) 
{
	servicioPeriodo.eliminarPoID(cod);
	redirect.addFlashAttribute("MENSAJE","Periodo eliminado correctamente");
	
	return "redirect:/periodos/lista";
}


	
	

}
