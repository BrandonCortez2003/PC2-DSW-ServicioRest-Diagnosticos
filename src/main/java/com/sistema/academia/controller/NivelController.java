package com.sistema.academia.controller;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistema.academia.entities.Nivel;
import com.sistema.academia.entities.Periodo;
import com.sistema.academia.services.NivelServices;
import com.sistema.academia.services.PeriodoServices;

@Controller
@RequestMapping("/nivel")
public class NivelController {

	@Autowired
	private PeriodoServices serviciope;
	
	@Autowired
	private NivelServices servicioni;
	
	@RequestMapping("/lista")
	public String Index(Model  model)
	{
		model.addAttribute("periodo", serviciope.listarTodos());
		model.addAttribute("nivel", servicioni.listarTodos());
		
		return "nivel";
	}

	//@RequestParam, permite recuperar valores que se encuentran en los
		//controles del formulario(cajas,checkbox,radio,etc)
		@RequestMapping("/grabar")
		public String grabar(@RequestParam("codigo") Integer cod,
							 @RequestParam("nivel") String ni,
							 @RequestParam("turno") String tur,
							 @RequestParam("horaIni") LocalTime ini,
							 @RequestParam("horaFin") LocalTime fin,
							 @RequestParam("estado") Boolean est,
							 
							 @RequestParam("periodo") int pr,
							 RedirectAttributes redirect) {
			try {
				//crear objeto de la entidad Medicamento
				Nivel nivel=new Nivel();
				//setear atributos del objeto "med" con los paràmetros
				nivel.setNivel(ni);
				nivel.setTurno(tur);
				nivel.setHoraIni(ini);
				nivel.setHoraFin(fin);
				nivel.setEstado(est);
				
				//crear un objeto de la entidad TipoMedicamento
				Periodo p=new Periodo();
				//setear atributo "codigo" del objeto "tm" con el paràmetro codTipo 
				p.setCodigo(pr);
				//invocar al mètodo setTipo y enviar el objeto "tm"
				nivel.setPeriodo(p);
				//validar paràmetro "cod"
				if(cod==0) {
					//invocar mètodo registrar
					servicioni.registrar(nivel);
					//crear atributo de tipo flash
					redirect.addFlashAttribute("MENSAJE","Medicamento registrado");
				}
				else {
					//setear atributo còdigo
					nivel.setCodigo(cod);
					servicioni.actualizar(nivel);
					redirect.addFlashAttribute("MENSAJE","Medicamento actualizado");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}	
			return "redirect:/nivel/lista";
		}
		
		//crear ruta o direcciòn URL para buscar medicamento según còdigo
		@RequestMapping("/buscar")
		@ResponseBody
		public Nivel buscar(@RequestParam("codigo") Integer cod ) {
			return servicioni.buscarPorID(cod);
		}
		
		//crear ruta o direcciòn URL para eliminar medicamento según còdigo
		@RequestMapping("/eliminar")
		public String eliminar(@RequestParam("codigo") Integer cod,RedirectAttributes redirect) {
			servicioni.eliminarPorID(cod);
			redirect.addFlashAttribute("MENSAJE","Mendicamento eliminado");
			return "redirect:/nivel/lista";
		}
}
