package com.sistema.academia.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@JsonIgnore
	//Relacion con alumno
	@OneToMany(mappedBy = "distrito")
	private List<Alumno> listarAlumno;

	@JsonIgnore
	//Relacion con apoderado
	@OneToMany(mappedBy = "distrito")
	private List<Apoderado> listarApoderado;

	@JsonIgnore
	//Relacion con docente
	@OneToMany(mappedBy = "distrito")
	private List<Profesor> listaProfesor;


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Alumno> getListarAlumno() {
		return listarAlumno;
	}


	public void setListarAlumno(List<Alumno> listarAlumno) {
		this.listarAlumno = listarAlumno;
	}


	public List<Apoderado> getListarApoderado() {
		return listarApoderado;
	}


	public void setListarApoderado(List<Apoderado> listarApoderado) {
		this.listarApoderado = listarApoderado;
	}


	public List<Profesor> getListaProfesor() {
		return listaProfesor;
	}


	public void setListaProfesor(List<Profesor> listaProfesor) {
		this.listaProfesor = listaProfesor;
	}
	
	
	
	
	
}
