package com.sistema.academia.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistema.academia.dto.DetalleNivelSeccion;
import com.sistema.academia.entities.Nivel;
import com.sistema.academia.entities.NivelDetalle;
import com.sistema.academia.entities.Seccion;
import com.sistema.academia.services.NivelDetalleServices;
import com.sistema.academia.services.NivelServices;
import com.sistema.academia.services.PeriodoServices;
import com.sistema.academia.services.SeccionServices;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/seccionNivel")
public class SeccionNivelController {
	
	@Autowired
	private SeccionServices servicioSeccion;
	
	@Autowired
	private PeriodoServices servicioPeriodo;
	
	@Autowired
	private NivelServices servicioNivel;
	
	@Autowired
	private NivelDetalleServices servicioNivelDet;
	

	@RequestMapping("/lista")
	public String lista(Model model) {
		
		model.addAttribute("seccion", servicioSeccion.listarTodos());
		model.addAttribute("periodos", servicioPeriodo.listarTodos());
		model.addAttribute("niveles",servicioNivel.listarTodos());
		model.addAttribute("detallesNivel", servicioNivelDet.listarTodos());
		return "seccionNivel";
	}
	
	@RequestMapping("/consultaSecciones")
	@ResponseBody
	public List<Seccion> obtenerTodasLasSecciones() {
        return servicioSeccion.listaTodasSecciones();
    }
	
	
	
	
	
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo") Integer cod,
						 @RequestParam("seccion") int codSec,
						 @RequestParam("nivel") int codNiv,
						
						 RedirectAttributes redirect) {
		

		try {
		
			NivelDetalle det = new NivelDetalle();
			
			Seccion sec  = new Seccion();
			
			Nivel  niv = new Nivel();
			
			sec.setCodigo(codSec);
			niv.setCodigo(codNiv);
			
			det.setSeccion(sec);
			det.setNivel(niv);
			
			servicioNivelDet.registrar(det);
			redirect.addFlashAttribute("MENSAJE","Registrado Correctamente");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		return "redirect:/seccionNivel/lista";
	}
	

}
