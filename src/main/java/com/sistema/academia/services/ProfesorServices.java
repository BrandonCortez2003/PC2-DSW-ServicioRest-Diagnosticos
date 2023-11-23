package com.sistema.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.academia.entities.Profesor;
import com.sistema.academia.repository.ProfesorRepository;

@Service
public class ProfesorServices {
	
	@Autowired
	private ProfesorRepository repo;
	
	public void registrar(Profesor pro) {
		repo.save(pro);
	}
	
	public void actualizar(Profesor pro) {
		repo.save(pro);
	}
	
	public void eliminarPorID(Integer cod) {
		repo.deleteById(cod);
	}
	
	public Profesor buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public List<Profesor> listarTodos(String palabraClave){
		
		if(palabraClave != null) {
			return repo.findAll(palabraClave);
		}
		return repo.findAll();
	}

}
