package com.sistema.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.academia.entities.Alumno;
import com.sistema.academia.repository.AlumnoRepository;

@Service
public class ALumnoServices {

	@Autowired
	private AlumnoRepository repo;

	public void registrar (Alumno alu)
	{
		 repo.save(alu);
	}
	
	public void actualizar(Alumno alu)
	{
		repo.save(alu);
	}
	
	public void eliminarPorID (Integer cod)
	{
		repo.deleteById(cod);
	}
	
	public Alumno buscarPorID (Integer cod)
	{
		return repo.findById(cod).orElseGet(null);
	}
	
	public List<Alumno> listarTodos()
	{
		return repo.findAll();
	}
	
	
	
	
	
}
