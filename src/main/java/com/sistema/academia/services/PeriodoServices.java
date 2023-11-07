package com.sistema.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.academia.entities.Periodo;
import com.sistema.academia.repository.PeriodoRepository;

@Service
public class PeriodoServices {

	@Autowired
	private PeriodoRepository repo;
	
	public void registrar(Periodo periodo)
	{
		repo.save(periodo);
	}
	
	public void actualizar(Periodo periodo)
	{
		repo.save(periodo);
	}
	
	public void eliminarPoID (Integer cod )
	{
		repo.deleteById(cod);
	}
	
	public Periodo buscarPorID(Integer cod)
	{
		return repo.findById(cod).orElse(null);
	}
	
	public List<Periodo> listarTodos()
	{
		return repo.findAll();
	}
	
}
