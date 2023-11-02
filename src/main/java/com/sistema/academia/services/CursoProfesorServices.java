package com.sistema.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.academia.entities.CursoProfesor;
import com.sistema.academia.repository.CursoProfesorRepository;


@Service
public class CursoProfesorServices {

	@Autowired
	private CursoProfesorRepository repo;
	
	public void registrar(CursoProfesor curpro) {
		repo.save(curpro);
	}
	
	public void actualizar(CursoProfesor curpro) {
		repo.save(curpro);
	}
	
	public void eliminarPorID(Integer cod) {
		repo.deleteById(cod);
	}
	
	public CursoProfesor buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public List<CursoProfesor> listarTodos(){
		return repo.findAll();
	}

	
}
