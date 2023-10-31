package com.sistema.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.academia.entities.TurnoCurso;
import com.sistema.academia.repository.TurnoCursoRepository;

@Service
public class TurnoCursoServices {

	@Autowired
	private TurnoCursoRepository repo;
	
	public List<TurnoCurso> listarTodos()
	{
		return repo.findAll();
	}
	
}
