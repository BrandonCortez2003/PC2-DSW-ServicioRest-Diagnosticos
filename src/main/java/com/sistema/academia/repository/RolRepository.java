package com.sistema.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sistema.academia.entities.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer>{
	


}
