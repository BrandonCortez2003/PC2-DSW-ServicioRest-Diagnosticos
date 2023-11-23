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
@Table(name="tb_nivel_detalle_curso")
public class NivelDetalleCurso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_nivel_detalle_curso")
	private Integer codigoDetalleCurso;
	
	
	
	@Column(name="fecha_registro")
	@CreationTimestamp
	private LocalDateTime fechaRegistro;
	
	//Relacion con nivel detalle
	@ManyToOne
	@JoinColumn(name="cod_nivel_detalle")
	private NivelDetalle nivelDetalle;
	
	//Relacion con curso
	@ManyToOne
	@JoinColumn(name="cod_curso")
	private Curso curso;
	
	
	
	

	public Integer getCodigoDetalleCurso() {
		return codigoDetalleCurso;
	}

	public void setCodigoDetalleCurso(Integer codigoDetalleCurso) {
		this.codigoDetalleCurso = codigoDetalleCurso;
	}



	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public NivelDetalle getNivelDetalle() {
		return nivelDetalle;
	}

	public void setNivelDetalle(NivelDetalle nivelDetalle) {
		this.nivelDetalle = nivelDetalle;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
	@PrePersist
	@PreUpdate
    protected void onCreate() {
		fechaRegistro = LocalDateTime.now();
    }
	
	
}
