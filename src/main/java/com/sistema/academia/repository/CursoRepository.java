package com.sistema.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.academia.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
