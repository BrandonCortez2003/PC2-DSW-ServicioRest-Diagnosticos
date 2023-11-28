package com.sistema.academia.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistema.academia.entities.Alumno;
import com.sistema.academia.entities.Apoderado;
import com.sistema.academia.entities.Distrito;
import com.sistema.academia.entities.Matricula;
import com.sistema.academia.entities.Nivel;
import com.sistema.academia.entities.Seccion;
import com.sistema.academia.services.ALumnoServices;
import com.sistema.academia.services.ApoderadoServices;
import com.sistema.academia.services.DistritoServices;
import com.sistema.academia.services.MatriculaServices;
import com.sistema.academia.services.NivelServices;
import com.sistema.academia.services.SeccionServices;

@Controller
@RequestMapping("/matricula")
public class MatriculaController {

	@Autowired
	private DistritoServices servicioDis;
	
	@Autowired
	private NivelServices servicioNivel;
	
	@Autowired
	private SeccionServices servicioSec;
	
	@Autowired
	private ALumnoServices servicioAlu;
	
	@Autowired
	private ApoderadoServices servicioApo;
	
	@Autowired
	private MatriculaServices servicioMat;
	
	@RequestMapping("/lista")
	public String Index(Model model) {
		
		model.addAttribute("distritos", servicioDis.listaDistrito());
		model.addAttribute("niveles", servicioNivel.listarTodos());
		model.addAttribute("seccion", servicioSec.listarTodos());
		
		return "matricula";
	}
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo")Integer cod,
						 @RequestParam("institutoprocedencia") String insti,
						 @RequestParam("nivel") int codNiv,
						 @RequestParam("seccion") int codSec,
						 @RequestParam("dniAlu") String dniAlu,
						 @RequestParam("nomAlu") String nomAlu,
						 @RequestParam("apeAlu") String apeAlu,
						 @RequestParam("naciAlu") String fecAlu,
						 @RequestParam("sexoAlu") String sexoAlu,
						 @RequestParam("distritoAlu") int distritoAlu,
						 @RequestParam("direcAlu") String direcAlu,
						 
						 @RequestParam("relaAPode")String relaAPode,
						 @RequestParam("dniApode")String dniApode,
						 @RequestParam("nomApode") String nomApode,
						 @RequestParam("apeApode") String apeApode,
						 @RequestParam("naciApode") String fecApode,
						 @RequestParam("sexoapode")String sexoapode,
						 @RequestParam("estadoapode")String estadoapode,
						 @RequestParam("distritoApode") int distritoApode,
						 @RequestParam("direApode") String direApode,
						 RedirectAttributes redirect)
	{
		
		try {
			
			Distrito dis = new Distrito();
			
			
			Alumno alu = new Alumno();
			alu.setNombre(nomAlu);
			alu.setApellido(apeAlu);
			alu.setDni(dniAlu);
			alu.setFechanaci(LocalDate.parse(fecAlu));
			alu.setSexo(sexoAlu);
			alu.setDireccion(direcAlu);
			
			dis.setCodigo(distritoAlu);
			alu.setDistrito(dis);
			
			servicioAlu.registrar(alu);
			
			Apoderado apode = new Apoderado();
			apode.setRelacionApode(relaAPode);
			apode.setNombre(nomApode);
			apode.setApellido(apeApode);
			apode.setDni(dniApode);
			apode.setFechaNaci(LocalDate.parse(fecApode));
			apode.setSexo(sexoapode);
			apode.setEstadoCivil(estadoapode);
			apode.setDireccion(direApode);
			
			dis.setCodigo(distritoApode);
			apode.setDistrito(dis);
			
			servicioApo.registrar(apode);
			
			Nivel niv = new Nivel();
			Seccion sec = new Seccion();
			
			
			Matricula mat = new Matricula();
			niv.setCodigo(codNiv);		
			mat.setNivel(niv);
			
			sec.setCodigo(codSec);
			mat.setSeccion(sec);
			
			mat.setAlumno(alu);
			mat.setApoderado(apode);
			mat.setInstitutoPro(insti);
			
			
			servicioMat.registrar(mat);
			redirect.addFlashAttribute("MENSAJE","Matricula Registrada Correctamente");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		
		
		
		return "redirect:/matricula/lista";
	}
	
}
