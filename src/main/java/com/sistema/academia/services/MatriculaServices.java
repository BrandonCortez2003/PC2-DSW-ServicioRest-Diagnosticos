package com.sistema.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.academia.entities.Matricula;
import com.sistema.academia.repository.MatriculaRepository;

@Service
public class MatriculaServices {

	@Autowired
	private MatriculaRepository repo;
	
	public void registrar(Matricula mat) {
		repo.save(mat);
	}
	
	public void eliminarPorID(Integer cod) {
		repo.deleteById(cod);
	}
	
	public Matricula buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public List<Matricula> listarTodos()
	{
		return repo.findAll();
	}
	
}
