package com.sistema.academia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistema.academia.entities.Enlace;
import com.sistema.academia.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>  {
	
	Usuario findByDni(String dni);
	
	@Query("select u from Usuario u where u.login=?1")
	public Usuario iniciarSesion(String vlogin);
	
	@Query("select e from RolEnlace re join re.enlace e where re.rol.descripcion=?1")
	public List<Enlace> traerEnlacesDelUsuario(String desRol);
}
