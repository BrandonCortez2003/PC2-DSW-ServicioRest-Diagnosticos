package com.sistema.academia.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_distrito")
public class Distrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_dis")
	private Integer codigo;
	
	@Column(name="nom_dis")
	private String nombre;
	
	//Relacion con alumno
	@OneToMany(mappedBy = "distrito")
	private List<Alumno> listarAlumno;

	//Relacion con apoderado
	@OneToMany(mappedBy = "distrito")
	private List<Apoderado> listarApoderado;
	
	
	//Relacion con docente
	@OneToMany(mappedBy = "distrito")
	private List<Profesor> listaProfesor;
	
}
