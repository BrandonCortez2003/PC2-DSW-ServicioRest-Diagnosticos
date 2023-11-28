package com.sistema.academia.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.academia.entities.Enlace;
import com.sistema.academia.entities.Rol;
import com.sistema.academia.entities.Usuario;
import com.sistema.academia.repository.RolRepository;
import com.sistema.academia.repository.UsuarioRepository;

@Service
public class UsuarioServices {

	@Autowired
	private UsuarioRepository repo;
	
	
	private Map<String, Boolean> dniCache = new HashMap<>();
	
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
	

	public boolean existeDni(String dni) {
		 Usuario usuario = repo.findByDni(dni); 

	        return usuario != null; 
	    }

	public String guardarUsuario(Usuario usuario) {
        
        
		String dni = usuario.getDni();

		        // Verificar si el DNI ya está en la caché
		        Boolean dniExistente = dniCache.get(dni);

		        if (dniExistente != null && dniExistente) {
		            return "El DNI ya está registrado en el sistema";
		        } else {
		            Usuario usuarioExistente = repo.findByDni(dni);

		            if (usuarioExistente != null) {
		                dniCache.put(dni, 
		             
		true); // Almacenar en caché el DNI verificado
		                return "El DNI ya está registrado en el sistema";
		            } else {
		                // Guardar el usuario en la base de datos y actualizar la caché si es necesario
		                repo.save(usuario);
		                dniCache.put(dni, 
		             
		true);
		                return "Usuario registrado correctamente";
		            }
		        }
		    }
		
}
		
