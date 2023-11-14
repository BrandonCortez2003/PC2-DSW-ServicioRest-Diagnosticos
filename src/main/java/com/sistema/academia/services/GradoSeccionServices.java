package com.sistema.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.academia.entities.Curso;
import com.sistema.academia.entities.Seccion;
import com.sistema.academia.repository.CursoRepository;
import com.sistema.academia.repository.GradoSeccionRepository;

@Service
public class GradoSeccionServices {

	@Autowired
	private GradoSeccionRepository repo;
	@Autowired
	private CursoRepository repoCurso;
	
	public void registrar(Seccion gradoS)
	{
		repo.save(gradoS);
	}
	
	public void actualizar(Seccion gradoS)
	{
		repo.save(gradoS);
	}
	
	public void eliminarPoID (Integer cod )
	{
		repo.deleteById(cod);
	}
	
	public Seccion buscarPorID(Integer cod)
	{
		return repo.findById(cod).orElse(null);
	}
	
	public List<Seccion> listarTodos()
	{
		return repo.findAll();
	}
	
	public List<Curso> listarTodoslosCursos()
	{
		return repoCurso.findAll();
	}
	
}
