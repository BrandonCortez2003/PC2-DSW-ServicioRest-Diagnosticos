package com.sistema.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sistema.academia.entities.Seccion;
import com.sistema.academia.repository.SeccionRepository;

@Service
public class SeccionServices {
	
	@Autowired
private SeccionRepository repo;
	
	public void registrar(Seccion seccion)
	{
		repo.save(seccion);
	}
	
	public void actualizar(Seccion seccion)
	{
		repo.save(seccion);
	}
	
	public void eliminarPoID (Integer cod )
	{
		repo.deleteById(cod);
	}
	
	public Seccion buscarPorID(Integer cod)
	{
		return repo.findById(cod).orElse(null);
	}
	
	public List<Seccion> listarTodos()
	{
		return repo.findAll();
	}
	
	public List<Seccion> listaTodasSecciones(){
		return repo.listarSecciones();
	}
	
}
