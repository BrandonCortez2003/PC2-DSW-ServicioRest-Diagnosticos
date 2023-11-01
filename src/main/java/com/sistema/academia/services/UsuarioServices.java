package com.sistema.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.academia.entities.Enlace;
import com.sistema.academia.entities.Usuario;
import com.sistema.academia.repository.UsuarioRepository;

@Service
public class UsuarioServices {

	@Autowired
	private UsuarioRepository repo;
	

	public Usuario iniciarSesion(String vlogin){
		return repo.iniciarSesion(vlogin);
	}
	
	
	public List<Enlace> traerEnlacesDelUsuario(String desRol){
		return repo.traerEnlacesDelUsuario(desRol);
	}
	
}
