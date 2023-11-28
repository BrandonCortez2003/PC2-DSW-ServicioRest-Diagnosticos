package com.sistema.academia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistema.academia.entities.Curso;


public interface CursoRepository extends JpaRepository<Curso, Integer>{
	

	/*@Query(value = "SELECT * FROM tb_curso ", nativeQuery = true)
	public List<Curso> listarCursos();*/
	
	@Query(value = "SELECT c FROM Curso c where c.descripcion like %?1%")
	public List<Curso> findAll(String palabraClave);
	


	@Query(value = "SELECT * FROM tb_curso ", nativeQuery = true)
	public List<Curso> listarCursos();
	


}
