package com.sistema.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.academia.entities.Distrito;
import com.sistema.academia.repository.DistritoRepository;

@Service
public class DistritoServices {

	@Autowired
	private DistritoRepository repo;
	
	public List<Distrito> listaDistrito()
	{
		return repo.findAll();
	}
	
}
