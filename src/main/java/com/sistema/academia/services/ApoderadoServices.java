package com.sistema.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sistema.academia.entities.Apoderado;
import com.sistema.academia.repository.ApoderadoRepository;

@Service
public class ApoderadoServices {
	
	@Autowired
	private ApoderadoRepository repo;

	public void registrar (Apoderado apoderado)
	{
		 repo.save(apoderado);
	}
	
	public void actualizar(Apoderado apoderado)
	{
		repo.save(apoderado);
	}
	
	public void eliminarPorID (Integer cod)
	{
		repo.deleteById(cod);
	}
	
	public Apoderado buscarPorID (Integer cod)
	{
		return repo.findById(cod).orElseGet(null);
	}
	
	public List<Apoderado> listarTodos()
	{
		return repo.findAll();
	}
	
}
