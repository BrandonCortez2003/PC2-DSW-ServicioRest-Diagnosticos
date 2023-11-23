package com.sistema.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.academia.entities.Horario;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {

}
