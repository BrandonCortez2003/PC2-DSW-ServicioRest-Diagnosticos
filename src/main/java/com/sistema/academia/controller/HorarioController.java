package com.sistema.academia.controller;

import java.sql.Time;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistema.academia.entities.Horario;
import com.sistema.academia.entities.NivelDetalleCurso;
import com.sistema.academia.services.HorarioServices;
import com.sistema.academia.services.NivelDetalleCursoServices;

@Controller
@RequestMapping("/horario")
public class HorarioController {
	
	@Autowired
	private HorarioServices servicioHorario;

	@Autowired
	private NivelDetalleCursoServices servicioDetallecurso;
	
	
	@RequestMapping("/lista")
	public String Index(Model model) {
		
		model.addAttribute("horario", servicioHorario.listarTodos());
		model.addAttribute("nivelDetalleCurso", servicioDetallecurso.listarTodos());
		
		return "horario";
	}
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo") Integer cod,
						 @RequestParam("curso") int codCurso,
						 @RequestParam("semana") String semana,
						 @RequestParam("horaIni") LocalTime ini,
						 @RequestParam("horaFin") LocalTime fin,
						 @RequestParam("estado") Boolean est,
						 RedirectAttributes redirect )
	{
		
		try {
			
			Horario hora = new Horario();
			
			hora.setCodigo(cod);
			hora.setDiaSemana(semana);
			hora.setHoraIni(ini);
			hora.setHoraFin(fin);
			hora.setEstado(est);
			
			NivelDetalleCurso detalle = new NivelDetalleCurso();
			
			detalle.setCodigoDetalleCurso(codCurso);
			
			hora.setNiveldetallecurso(detalle);
			
			
			if(cod == 0) {
				servicioHorario.registrar(hora);
				redirect.addFlashAttribute("MENSAJE","Horario registrado");
			}
			else {
				hora.setCodigo(cod);
				servicioHorario.actualizar(hora);
				redirect.addFlashAttribute("MENSAJE","Horario actualizado");
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return "redirect:/horario/lista";
	}
	
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Horario buscar(@RequestParam("codigo")Integer cod) {
		return servicioHorario.buscarPorID(cod);
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("codigo") Integer cod,RedirectAttributes redirect) {
		servicioHorario.eliminarPorID(cod);
		redirect.addFlashAttribute("MENSAJE","Horario eliminado");
		return "redirect:/horario/lista";
	}

}
