package com.sistema.academia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistema.academia.entities.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer>{
	 
	@Query("SELECT p FROM Profesor p WHERE p.nombre LIKE %?1% "
			+ "OR p.apellido LIKE %?1%"
			+ "OR p.gradoStudio LIKE %?1%")
	public List<Profesor> findAll(String palabraClave);
	
}
