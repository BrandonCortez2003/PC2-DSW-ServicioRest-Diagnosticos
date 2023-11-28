package com.sistema.academia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sistema.academia.entities.NivelDetalleCurso;

public interface NivelDetalleCursoRepository extends JpaRepository<NivelDetalleCurso, Integer> {
	
	
	/*List<NivelDetalleCurso> buscarPorNombreCurso(String nombreCurso);
	
	@Query("SELECT ndc FROM NivelDetalleCurso ndc " +
		       "JOIN ndc.curso c " +
		       "WHERE c.descripcion LIKE CONCAT('%', :nombreCurso, '%')")
	List<NivelDetalleCurso> findByDescripcionCursoContaining(@Param("nombreCurso") String nombreCurso);*/

	
}
