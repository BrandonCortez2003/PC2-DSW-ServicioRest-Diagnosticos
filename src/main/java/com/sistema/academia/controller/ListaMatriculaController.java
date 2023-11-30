	package com.sistema.academia.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistema.academia.entities.Alumno;
import com.sistema.academia.entities.Matricula;
import com.sistema.academia.entities.Profesor;
import com.sistema.academia.services.MatriculaServices;
import com.sistema.academia.util.reportesExcel.AlumnoReporteExcel;
import com.sistema.academia.util.reportesExcel.MatriculaReporteExcel;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/listaMatricula")
public class ListaMatriculaController {
	
	@Autowired
	private MatriculaServices servicioMat;
	
	@RequestMapping("/lista")
	public String Index(Model model) {
		
		model.addAttribute("matricula", servicioMat.listarTodos());
		
		return "listaMatricula";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Matricula buscarMatricula (@RequestParam("codigo") Integer cod)
	{
		return servicioMat.buscarPorID(cod);
	}

	@RequestMapping("/eliminar")
	public String eliminarPorCodigo(@RequestParam("codigo")Integer cod,
									RedirectAttributes redirect) 
	{
		servicioMat.eliminarPorID(cod);
		redirect.addFlashAttribute("MENSAJE","Matricula eliminada correctamente");
		
		return "redirect:/listaMatricula/lista";
	}
	
	@RequestMapping("/exportar-matricula-excel") 
	public void exportarMatriculaEnExcel(HttpServletResponse response) throws IOException {
	    response.setContentType("application/octet-stream");

	    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-d_HH:mm:ss");
	    String fechaActual = dateFormatter.format(new Date());

	    String cabecera = "Content-Disposition";
	    String valor = "attachment; filename=Matricula_" + fechaActual + ".xlsx";

	    response.setHeader(cabecera, valor);

	    List<Matricula> matricula = servicioMat.listarTodos();

	    MatriculaReporteExcel exporter = new MatriculaReporteExcel(matricula);
	    exporter.exportar(response);
	}

}
