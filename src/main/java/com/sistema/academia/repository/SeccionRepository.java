package com.sistema.academia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistema.academia.entities.Seccion;

public interface SeccionRepository extends JpaRepository<Seccion, Integer>{
	
	@Query(value = "SELECT * FROM tb_seccion ", nativeQuery = true)
	public List<Seccion> listarSecciones();
	
	
	
	


}
