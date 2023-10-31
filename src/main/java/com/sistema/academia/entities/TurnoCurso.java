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
@Table(name="tb_turno")
public class TurnoCurso {
	
	@Id
	@Column(name="cod_turn")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="nom_turn")
	private String nombre;
	
	@JsonIgnore
	
	//Relacion
	@OneToMany (mappedBy = "turnoCurs")
	private List<Curso> listarCurso;

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

	public List<Curso> getListarCurso() {
		return listarCurso;
	}

	public void setListarCurso(List<Curso> listarCurso) {
		this.listarCurso = listarCurso;
	}
	
	

}
