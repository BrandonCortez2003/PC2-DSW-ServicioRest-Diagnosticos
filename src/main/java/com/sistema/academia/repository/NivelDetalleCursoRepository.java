package com.sistema.academia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sistema.academia.entities.NivelDetalleCurso;

public interface NivelDetalleCursoRepository extends JpaRepository<NivelDetalleCurso, Integer> {
	
	 @Query(value = "SELECT ndc.cod_curso, c.des_curso FROM tb_nivel_detalle_curso ndc JOIN tb_curso c ON ndc.cod_curso = c.cod_curso WHERE ndc.cod_nivel = :codNivel AND ndc.cod_seccion = :codSeccion", nativeQuery = true)
	    List<Object[]> findCodigosNombresCursosByNivelAndSeccion(@Param("codNivel") Integer codNivel, @Param("codSeccion") Integer codSeccion);
}
