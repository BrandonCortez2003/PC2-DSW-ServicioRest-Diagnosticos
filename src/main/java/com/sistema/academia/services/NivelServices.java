package com.sistema.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.academia.entities.Nivel;
import com.sistema.academia.repository.NivelRepository;

@Service
public class NivelServices {

	@Autowired
	private NivelRepository repo;
	
	public void registrar(Nivel pro) {
		repo.save(pro);
	}
	
	public void actualizar(Nivel pro) {
		repo.save(pro);
	}
	
	public void eliminarPorID(Integer cod) {
		repo.deleteById(cod);
	}
	
	public Nivel buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public List<Nivel> listarTodos()
	{
		return repo.findAll();
	}
}
