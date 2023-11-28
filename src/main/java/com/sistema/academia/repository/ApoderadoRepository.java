package com.sistema.academia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistema.academia.entities.Apoderado;

public interface ApoderadoRepository extends JpaRepository<Apoderado, Integer>{

	 
		@Query("SELECT p FROM Apoderado p WHERE p.nombre LIKE %?1% "
				+ "OR p.apellido LIKE %?1%"
				+ "OR p.dni LIKE %?1%")
		public List<Apoderado> findAll(String palabraClave);
	
}
