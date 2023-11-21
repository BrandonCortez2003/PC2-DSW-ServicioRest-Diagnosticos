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
	
	public void registrar(Usuario usu) {
		repo.save(usu);
	}

	public Usuario iniciarSesion(String vlogin){
		return repo.iniciarSesion(vlogin);
	}
	
	
	public List<Enlace> traerEnlacesDelUsuario(String desRol){
		return repo.traerEnlacesDelUsuario(desRol);
	}
	

	public void guardar(Usuario usu) {
		repo.save(usu);
	}
	
	public void actualizar (Usuario usu){
		repo.save(usu);
	}
	
	public void eliminarPorID (Integer cod) {
		repo.deleteById(cod);
	}
	
	public Usuario buscarPorID (Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public List<Usuario> listarTodos() {
		return repo.findAll();
		}
	
	public boolean existsByDni(String dni) {
	    // Lógica para verificar si el DNI ya existe en la base de datos
	    // Esto puede ser una llamada a tu capa de persistencia o base de datos
	    return repo.existsByDni(dni);
	}

	 public void guardarUsuario(Usuario usuario) {
	        // Aquí puedes realizar validaciones adicionales, lógica de negocio, etc.,
	        // antes de guardar el usuario en la base de datos, si es necesario.
	        repo.save(usuario);
	    }

	
}


