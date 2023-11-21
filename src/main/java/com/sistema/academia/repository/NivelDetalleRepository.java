package com.sistema.academia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.academia.entities.NivelDetalle;

public interface NivelDetalleRepository extends JpaRepository<NivelDetalle, Integer> {
	


}
