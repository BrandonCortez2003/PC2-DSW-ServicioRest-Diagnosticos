package com.sistema.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.academia.entities.Seccion;

public interface GradoSeccionRepository extends JpaRepository<Seccion, Integer> {

}
