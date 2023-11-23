package com.sistema.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.academia.entities.Curso;
import com.sistema.academia.entities.Seccion;
import com.sistema.academia.repository.CursoRepository;

@Service
public class CursoServices {

	@Autowired
	private CursoRepository repo;
	
	public void registrar(Curso curso)
	{
		repo.save(curso);
	}
	
	public void actualizar(Curso curso)
	{
		repo.save(curso);
	}
	
	public void eliminarPoID (Integer cod )
	{
		repo.deleteById(cod);
	}
	
	public Curso buscarPorID(Integer cod)
	{
		return repo.findById(cod).orElse(null);
	}
	
	public List<Curso> listarTodos()
	{
		return repo.findAll();
	}
	
	public List<Curso> listaCursos(){
		return repo.listarCursos();
	}
	
}
