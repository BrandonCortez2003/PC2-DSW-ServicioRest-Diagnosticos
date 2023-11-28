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

import com.sistema.academia.dto.DetalleNivelCurso;
import com.sistema.academia.dto.DetalleNivelSeccion;
import com.sistema.academia.entities.Curso;
import com.sistema.academia.entities.Nivel;
import com.sistema.academia.entities.NivelDetalle;
import com.sistema.academia.entities.NivelDetalleCurso;
import com.sistema.academia.entities.Seccion;
import com.sistema.academia.services.CursoServices;
import com.sistema.academia.services.NivelDetalleCursoServices;
import com.sistema.academia.services.NivelDetalleServices;
import com.sistema.academia.services.NivelServices;
import com.sistema.academia.services.PeriodoServices;
import com.sistema.academia.services.SeccionServices;

import jakarta.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/detalleCurso")
public class DetalleCursoController {
	
	@Autowired
	private CursoServices servicioCurso;
	
	@Autowired
	private PeriodoServices servicioPeriodo;
	
	@Autowired
	private SeccionServices servicioSeccion;
	
	@Autowired
	private NivelServices servicioNivel;
	
	@Autowired
	private NivelDetalleCursoServices servicioNivelDetCurso;


	@RequestMapping("/lista")
	public String lista(Model model) {

		//String buscarPorNombreCurso ="Matematica tu";
		model.addAttribute("curso", servicioCurso.listAll(null));


		model.addAttribute("periodos", servicioPeriodo.listarTodos());
		model.addAttribute("secciones", servicioSeccion.listarTodos());
		model.addAttribute("niveles", servicioNivel.listarTodos());

		return "detalleCurso";
	}
	
	@RequestMapping("/consultaCursos")
	@ResponseBody
	public List<Curso> obtenerTodosLosCursos() {
        return servicioCurso.listAll(null);
    }
	
	
	@RequestMapping("/adicionar")
	@ResponseBody
	public List<DetalleNivelCurso>adicionar(@RequestParam("codigo") int cod,
			  @RequestParam("descripcion") String des,
			  HttpServletRequest request)
	{
		List<DetalleNivelCurso> lista = null;
		
		if(request.getSession().getAttribute("datos")==null)
		lista = new ArrayList<DetalleNivelCurso>();
		else 
		lista=(List<DetalleNivelCurso>) request.getSession().getAttribute("datos");
		
		DetalleNivelCurso det = new DetalleNivelCurso();
		
		det.setCodigo(cod);
		det.setDescripcion(des);
		
		lista.add(det);
		request.getSession().setAttribute("datos", lista);
		
		return lista;
	}
	
	
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("nivel") int codNiv,
						 @RequestParam("seccion") int codSec,
						 HttpServletRequest request,RedirectAttributes redirect) {
		
		try {
			
				NivelDetalleCurso bean = new NivelDetalleCurso();
				Nivel niv = new Nivel();
				Seccion sec = new Seccion();
				niv.setCodigo(codNiv);
				sec.setCodigo(codSec);
				bean.setNivel(niv);
				bean.setSeccion(sec);
				
				List<DetalleNivelCurso> lista =(List<DetalleNivelCurso>) request.getSession().getAttribute("datos");
				List<NivelDetalleCurso> detalle = new ArrayList<NivelDetalleCurso>();
				
				for(DetalleNivelCurso de : lista) {
					NivelDetalleCurso br = new NivelDetalleCurso();
					Curso c = new Curso();
					c.setCodigo(de.getCodigo());
					br.setCurso(c);
					
					detalle.add(br);
				}
				
				servicioNivelDetCurso.registrarNivCurso(bean, detalle);
				lista.clear();
				request.getSession().setAttribute("datos",lista);
				redirect.addFlashAttribute("MENSAJE","Detalle registrado");
			
			
			
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en el registro");
			e.printStackTrace();
		}
		
		
		
		return "redirect:/detalleCurso/lista";
	}
	
	
	
	

}
