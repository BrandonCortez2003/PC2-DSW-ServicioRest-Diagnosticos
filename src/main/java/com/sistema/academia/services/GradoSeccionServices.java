package com.sistema.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.academia.entities.Curso;
import com.sistema.academia.entities.GradoSeccion;
import com.sistema.academia.repository.CursoRepository;
import com.sistema.academia.repository.GradoSeccionRepository;

@Service
public class GradoSeccionServices {

	@Autowired
	private GradoSeccionRepository repo;
	@Autowired
	private CursoRepository repoCurso;
	
	public void registrar(GradoSeccion gradoS)
	{
		repo.save(gradoS);
	}
	
	public void actualizar(GradoSeccion gradoS)
	{
		repo.save(gradoS);
	}
	
	public void eliminarPoID (Integer cod )
	{
		repo.deleteById(cod);
	}
	
	public GradoSeccion buscarPorID(Integer cod)
	{
		return repo.findById(cod).orElse(null);
	}
	
	public List<GradoSeccion> listarTodos()
	{
		return repo.findAll();
	}
	
	public List<Curso> listarTodoslosCursos()
	{
		return repoCurso.findAll();
	}
	
}
