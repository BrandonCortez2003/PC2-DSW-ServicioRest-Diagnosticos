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
		
		
		model.addAttribute("periodos", servicioPeriodo.listarTodos());
		model.addAttribute("niveles",servicioNivel.listarTodos());

		return "seccionNivel";
	}
	
	@RequestMapping("/consultaSecciones")
	@ResponseBody
	public List<Seccion> obtenerTodasLasSecciones() {
        return servicioSeccion.listaTodasSecciones();
    }
	

	@RequestMapping("/adicionar")
	@ResponseBody
	public List<DetalleNivelSeccion>adicionar(@RequestParam("codigo") int cod,
											  @RequestParam("descripSeccion") String des,
											  HttpServletRequest request)
	{
		List<DetalleNivelSeccion> lista = null;
		
		if(request.getSession().getAttribute("datos")==null)
			lista = new ArrayList<DetalleNivelSeccion>();
		else 
			lista=(List<DetalleNivelSeccion>) request.getSession().getAttribute("datos");
		
		DetalleNivelSeccion det = new DetalleNivelSeccion();
		
		det.setCodigo(cod);
		det.setDescripSeccion(des);
		
		lista.add(det);
		request.getSession().setAttribute("datos", lista);
				
		return lista;
	}
	
	
	@RequestMapping("/eliminar")
	@ResponseBody
	public List<DetalleNivelSeccion> eliminar(@RequestParam("codigo") int codigo, HttpServletRequest request) {
	    // Obtener la lista actual de detalles almacenada en la sesión
	    List<DetalleNivelSeccion> lista = (List<DetalleNivelSeccion>) request.getSession().getAttribute("datos");

	    if (lista != null) {
	        // Eliminar el detalle correspondiente al código a eliminar
	        lista.removeIf(detalle -> detalle.getCodigo() == codigo);
	        // Actualizar la lista en la sesión
	        request.getSession().setAttribute("datos", lista);
	    }

	    return lista;
	}
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("nivel") int idNiv,
			HttpServletRequest request,RedirectAttributes redirect) {
		

		try {
				NivelDetalle bean = new NivelDetalle();
				
				Nivel niv = new Nivel();
				niv.setCodigo(idNiv);
				bean.setNivel(niv);
			
		
		
			List<DetalleNivelSeccion> lista =(List<DetalleNivelSeccion>) request.getSession().getAttribute("datos");
			List<NivelDetalle> detalle = new ArrayList<NivelDetalle>();
			
			for(DetalleNivelSeccion de : lista) {
				NivelDetalle br = new NivelDetalle();
				Seccion s = new Seccion();
				s.setCodigo(de.getCodigo());
				br.setSeccion(s);
				
				detalle.add(br);								
			}
			
			servicioNivelDet.registrarNivelSec(bean, detalle);
			lista.clear();
			request.getSession().setAttribute("datos",lista);
			redirect.addFlashAttribute("MENSAJE","Detalle registrado");
			
			
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en el registro");
			e.printStackTrace();
		}
		
	
		
		
		return "redirect:/seccionNivel/lista";
	}
	
	
/*	@RequestMapping("/buscar")
	@ResponseBody
	public NivelDetalle buscar(@RequestParam("codigo")Integer cod) {
		//return servicioNivelDet.buscarPorID(cod);
	}*/
	

	
	
}
