package com.sistema.academia.entities;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_matricula")
public class Matricula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_matricula")
	private Integer codigo;
	
	
	@Column(name="instituto_procedencia")
	private String institutoPro;
	
	
	@Column(name="fecha_registro")
	@CreationTimestamp
	private LocalDateTime fechaRegistro;
	
	
	//Relacion con alumno
	@ManyToOne
	@JoinColumn(name="cod_alu")
	private Alumno alumno;
	

	@ManyToOne
	@JoinColumn(name="cod_nivel")
	private Nivel nivel;
	
	@ManyToOne
	@JoinColumn(name = "cod_seccion")
	private Seccion seccion;

	
	//Relacion con apoderado
	@ManyToOne
	@JoinColumn(name="cod_apode")
	private Apoderado apoderado;
	
	
	
	
	public Integer getCodigo() {
		return codigo;
	}




	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}




	public String getInstitutoPro() {
		return institutoPro;
	}




	public void setInstitutoPro(String institutoPro) {
		this.institutoPro = institutoPro;
	}






	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}




	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}




	public Alumno getAlumno() {
		return alumno;
	}




	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}





	public Apoderado getApoderado() {
		return apoderado;
	}




	public void setApoderado(Apoderado apoderado) {
		this.apoderado = apoderado;
	}

	
	


	public Nivel getNivel() {
		return nivel;
	}




	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}




	public Seccion getSeccion() {
		return seccion;
	}




	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}




	@PrePersist
	@PreUpdate
    protected void onCreate() {
		fechaRegistro = LocalDateTime.now();
    }
	


}
