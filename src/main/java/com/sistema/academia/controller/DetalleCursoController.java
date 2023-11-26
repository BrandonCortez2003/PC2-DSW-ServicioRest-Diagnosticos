package com.sistema.academia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistema.academia.entities.Curso;

import com.sistema.academia.entities.NivelDetalle;
import com.sistema.academia.entities.NivelDetalleCurso;

import com.sistema.academia.services.CursoServices;
import com.sistema.academia.services.NivelDetalleCursoServices;
import com.sistema.academia.services.NivelDetalleServices;
import com.sistema.academia.services.NivelServices;
import com.sistema.academia.services.PeriodoServices;


@Controller
@RequestMapping("/detalleCurso")
public class DetalleCursoController {
	
	@Autowired
	private CursoServices servicioCurso;
	
	@Autowired
	private PeriodoServices servicioPeriodo;
	
	@Autowired
	private NivelDetalleServices servicioNivelDetalle;
	
	@Autowired
	private NivelDetalleCursoServices servicioNivelDetCurso;
	

	@RequestMapping("/lista")
	public String lista(Model model) {
		
		model.addAttribute("curso", servicioCurso.listarTodos());
		model.addAttribute("periodos", servicioPeriodo.listarTodos());
		model.addAttribute("niveldetalle",servicioNivelDetalle.listarTodos());
		model.addAttribute("detallesNivelCurso", servicioNivelDetCurso.listarTodos());
		return "detalleCurso";
	}
	
	@RequestMapping("/consultaCursos")
	@ResponseBody
	public List<Curso> obtenerTodosLosCursos() {
        return servicioCurso.listaCursos();
    }
	
	
	
	
	
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo") Integer cod,
						 @RequestParam("curso") int codCur,
						 @RequestParam("nivelDetalle") int codNivDet,
						
						 RedirectAttributes redirect) {
		

		try {
		
			NivelDetalleCurso det = new NivelDetalleCurso();
			
			Curso cur  = new Curso();
			
			NivelDetalle  nivDet = new NivelDetalle();
			
			cur.setCodigo(codCur);
			nivDet.setCodigoNivelDetalle(codNivDet);
			
			det.setCurso(cur);
			det.setNivelDetalle(nivDet);
			
			servicioNivelDetCurso.registrar(det);
			redirect.addFlashAttribute("MENSAJE","Registrado Correctamente");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return "redirect:/detalleCurso/lista";
	}
	
	
	@RequestMapping("/buscar")
	@ResponseBody
	public NivelDetalleCurso buscar(@RequestParam("codigo")Integer cod) {
		return servicioNivelDetCurso.buscarPorID(cod);
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("codigo") Integer cod,RedirectAttributes redirect) {
		servicioNivelDetCurso.eliminarPoID(cod);
		redirect.addFlashAttribute("MENSAJE","Detalle eliminado");
		return "redirect:/detalleCurso/lista";
	}
	

}
