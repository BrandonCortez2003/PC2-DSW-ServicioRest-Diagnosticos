package com.sistema.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistema.academia.entities.Alumno;
import com.sistema.academia.entities.Curso;
import com.sistema.academia.entities.CursoAlumno;
import com.sistema.academia.services.ALumnoServices;

import com.sistema.academia.services.CursoAlumnoServices;
import com.sistema.academia.services.CursoServices;

@Controller
@RequestMapping("/cursosalumno")
public class CursoAlumnoController {

	@Autowired
	private CursoServices servicioCurso;
	
	@Autowired
	private ALumnoServices servicioAlumno;
	
	@Autowired
	private CursoAlumnoServices servicioCursoAlumno;
	
	@RequestMapping("/lista")
	public String Index(Model model)
	{
		model.addAttribute("cursos", servicioCurso.listarTodos());
		model.addAttribute("alumno", servicioAlumno.listarTodos());
		model.addAttribute("cursosalumno", servicioCursoAlumno.listarTodos());
		
		return "cursosalumno";
	
	}
	
	@RequestMapping("/grabar")
	public String grabar (@RequestParam("codigo") Integer cod,
						@RequestParam("alumno")int codAlum,
						@RequestParam("curso")int  codCur,
						@RequestParam("promedio")String promedio,
						@RequestParam("asistencia")String asistencia,
						@RequestParam("faltas")String faltas,
						
						RedirectAttributes redirect)
		{
			try
			{
				
				CursoAlumno curso = new CursoAlumno();
				
				curso.setPromedio(promedio);
				curso.setAsistencia(asistencia);
				curso.setFaltas(faltas);
				
				Alumno alumno = new Alumno();
				Curso cursos = new Curso();
				
				alumno.setCodigo(codAlum);
				cursos.setCodigo(codCur);
				
				curso.setAlumno(alumno);
				curso.setCurso(cursos);
				
				if(cod == 0)
				{
					servicioCursoAlumno.registrar(curso);
					redirect.addFlashAttribute("MENSAJE","Curso Registrado Correctamente");
				}
				else
				{
					curso.setCodigo(cod);
					servicioCursoAlumno.actualizar(curso);
					redirect.addFlashAttribute("MENSAJE","Curso Actualizado Correctamente");
				}
				
				
				
			}
			catch(Exception e )
			{
				e.printStackTrace();
			}
			
			return "redirect:/cursosalumno/lista";
			
		
		}

	@RequestMapping("/buscar")
	@ResponseBody
	public CursoAlumno buscar (@RequestParam("codigo") Integer cod)
	{
		return servicioCursoAlumno.buscarPorID(cod);
	}

	@RequestMapping("/eliminar")
	public String eliminarPorCodigo(@RequestParam("codigo")Integer cod,
									RedirectAttributes redirect) 
	{
		servicioCursoAlumno.eliminarPoID(cod);
		redirect.addFlashAttribute("MENSAJE","Curso eliminado correctamente");
		
		return "redirect:/cursosalumno/lista";
	}
	
	
}
