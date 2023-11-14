package com.sistema.academia.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_matricula")
public class Matricula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_matricula")
	private Integer codigo;
	
	@Column(name="situ_matricula")
	private String situacion;
	
	@Column(name="intituto_procedencia")
	private String institutoPro;
	
	@Column(name="estado_matricula")
	private Boolean estado;
	
	@Column(name="fecha_registro")
	private LocalDateTime fechaRegistro;
	
	
	//Relacion con alumno
	@ManyToOne
	@JoinColumn(name="cod_alu")
	private Alumno alumno;
	
	//Relacion con nivel detalle
	@ManyToOne
	@JoinColumn(name="cod_nivel_detalle")
	private NivelDetalle nivelDetalle;
	
	
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




	public String getSituacion() {
		return situacion;
	}




	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}




	public String getInstitutoPro() {
		return institutoPro;
	}




	public void setInstitutoPro(String institutoPro) {
		this.institutoPro = institutoPro;
	}




	public Boolean getEstado() {
		return estado;
	}




	public void setEstado(Boolean estado) {
		this.estado = estado;
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




	public NivelDetalle getNivelDetalle() {
		return nivelDetalle;
	}




	public void setNivelDetalle(NivelDetalle nivelDetalle) {
		this.nivelDetalle = nivelDetalle;
	}




	public Apoderado getApoderado() {
		return apoderado;
	}




	public void setApoderado(Apoderado apoderado) {
		this.apoderado = apoderado;
	}




	@PrePersist
    protected void onCreate() {
		fechaRegistro = LocalDateTime.now();
    }
	

}
