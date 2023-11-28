package com.sistema.academia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistema.academia.entities.Alumno;


public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	
	 
		@Query("SELECT a FROM Alumno a WHERE a.nombre LIKE %?1% "
				+ "OR a.apellido LIKE %?1%")
		public List<Alumno> findAll(String palabraClave);

}
