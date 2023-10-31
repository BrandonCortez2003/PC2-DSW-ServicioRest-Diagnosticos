package com.sistema.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.academia.entities.TipoCurso;
import com.sistema.academia.repository.TipoCursoRepository;

@Service
public class TipoCursoServices {

	@Autowired
	private TipoCursoRepository repo;
	
	public List<TipoCurso> listarTodos()
	{
		return repo.findAll();
	}
	
}
