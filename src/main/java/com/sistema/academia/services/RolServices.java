package com.sistema.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.academia.entities.Rol;
import com.sistema.academia.repository.RolRepository;

@Service
public class RolServices {


	@Autowired
	private RolRepository repo;
	

	public void registrar (Rol rol){
		repo.save(rol);
	}
	
	public void actualizar (Rol rol){
		repo.save(rol);
	}
	
	public void eliminarPorID (Integer cod) {
		repo.deleteById(cod);
	}
	
	public Rol buscarPorID (Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public List<Rol> listarTodos() {
		return repo.findAll();
		}
}
