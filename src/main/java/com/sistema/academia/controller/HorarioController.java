package com.sistema.academia.controller;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistema.academia.entities.Curso;
import com.sistema.academia.entities.Horario;
import com.sistema.academia.entities.Nivel;
import com.sistema.academia.entities.NivelDetalleCurso;
import com.sistema.academia.entities.Seccion;
import com.sistema.academia.services.HorarioServices;
import com.sistema.academia.services.NivelDetalleCursoServices;
import com.sistema.academia.services.NivelServices;
import com.sistema.academia.services.PeriodoServices;
import com.sistema.academia.services.SeccionServices;

@Controller
@RequestMapping("/horario")
public class HorarioController {
	
	@Autowired
	private HorarioServices servicioHorario;
	
	@Autowired
	private PeriodoServices servicioPeriodo;
	
	@Autowired
	private NivelServices servicioNivel;
	
	@Autowired
	private SeccionServices servicioSec;

	@Autowired
	private NivelDetalleCursoServices servicioDetallecurso;
	
	
	@RequestMapping("/lista")
	public String Index(Model model) {
		
		model.addAttribute("periodos", servicioPeriodo.listarTodos());
		model.addAttribute("niveles", servicioNivel.listarTodos());
		model.addAttribute("secciones", servicioSec.listarTodos());
		model.addAttribute("horario", servicioHorario.listarTodos());

		
		return "horario";
	}
	
	@RequestMapping("/consultarCursosNivSec")
	@ResponseBody
	public List<Map<String, Object>> obtenerCursosPorNivelYSeccion(@RequestParam("codNivel") Integer codNivel, @RequestParam("codSeccion") Integer codSeccion) {
        return servicioDetallecurso.obtenerCursosPorNivelYSeccion(codNivel, codSeccion);
    }
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo") Integer cod,
						 @RequestParam("curso") int codCurso,
						 @RequestParam("nivel") int codNiv,
						 @RequestParam("seccion") int codSec,
						 @RequestParam("semana") String semana,
						 @RequestParam("horaInicio") LocalTime ini,
						 @RequestParam("horaFin") LocalTime fin,
						 
						 RedirectAttributes redirect )
	{
		
		try {
			
			Horario hora = new Horario();
				
			hora.setDiaSemana(semana);
			hora.setHoraIni(ini);
			hora.setHoraFin(fin);
			
			Nivel niv = new Nivel();
			Seccion sec = new Seccion();
			Curso cur = new Curso();

			niv.setCodigo(codNiv);
			sec.setCodigo(codSec);
			cur.setCodigo(codCurso);

			hora.setNivel(niv);
			hora.setSeccion(sec);
			hora.setCurso(cur);

			
			
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
