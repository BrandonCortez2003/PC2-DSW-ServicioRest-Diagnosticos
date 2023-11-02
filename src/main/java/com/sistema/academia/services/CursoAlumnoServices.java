package com.sistema.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.academia.entities.CursoAlumno;
import com.sistema.academia.repository.CursoAlumnoRepository;

@Service
public class CursoAlumnoServices {

	@Autowired
	private CursoAlumnoRepository repo;
	
	public void registrar(CursoAlumno cursoalumno)
	{
		repo.save(cursoalumno);
	}
	
	public void actualizar(CursoAlumno cursoalumno)
	{
		repo.save(cursoalumno);
	}
	
	public void eliminarPoID (Integer cod )
	{
		repo.deleteById(cod);
	}
	
	public CursoAlumno buscarPorID(Integer cod)
	{
		return repo.findById(cod).orElse(null);
	}
	
	public List<CursoAlumno> listarTodos()
	{
		return repo.findAll();
	}
}
