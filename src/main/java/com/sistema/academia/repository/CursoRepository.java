package com.sistema.academia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistema.academia.entities.Curso;
import com.sistema.academia.entities.Seccion;

public interface CursoRepository extends JpaRepository<Curso, Integer>{
	
	@Query(value = "SELECT * FROM tb_curso ", nativeQuery = true)
	public List<Curso> listarCursos();

}
