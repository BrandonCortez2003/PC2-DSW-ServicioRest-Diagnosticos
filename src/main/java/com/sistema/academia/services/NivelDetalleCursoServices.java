package com.sistema.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.academia.entities.NivelDetalle;
import com.sistema.academia.entities.NivelDetalleCurso;
import com.sistema.academia.repository.NivelDetalleCursoRepository;

@Service
public class NivelDetalleCursoServices {
	
	
	@Autowired
	private NivelDetalleCursoRepository repo;
	
	public void registrar(NivelDetalleCurso detalle)
	{
		repo.save(detalle);
	}
	
	
	public void eliminarPoID (Integer cod )
	{
		repo.deleteById(cod);
	}
	
	public NivelDetalleCurso buscarPorID(Integer cod)
	{
		return repo.findById(cod).orElse(null);
	}
	
	public List<NivelDetalleCurso> listarTodos()
	{
		return repo.findAll();
	}
	
	

	

	

}
