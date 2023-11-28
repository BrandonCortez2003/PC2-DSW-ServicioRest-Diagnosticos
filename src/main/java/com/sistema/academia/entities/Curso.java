package com.sistema.academia.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;



@Entity
@Table(name="tb_curso")
public class Curso {
	
	@Id
	@Column(name="cod_curso")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="des_curso")
	private String descripcion;
		
	@Column(name="estado_curso")
	private Boolean estado;
	
	@Column(name="fecha_registro")
	@CreationTimestamp
	private LocalDateTime fechaRegistro;
	
	@JsonIgnore
	
	//Relacion con nivel detalle curso
	@OneToMany(mappedBy = "curso")
	private List<NivelDetalleCurso> listaNivelDetalleCurso;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "curso")
	private List<Horario> listaCursoHorario;
	

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	

	
	
	public List<NivelDetalleCurso> getListaNivelDetalleCurso() {
		return listaNivelDetalleCurso;
	}

	public void setListaNivelDetalleCurso(List<NivelDetalleCurso> listaNivelDetalleCurso) {
		this.listaNivelDetalleCurso = listaNivelDetalleCurso;
	}

	public List<Horario> getListaCursoHorario() {
		return listaCursoHorario;
	}

	public void setListaCursoHorario(List<Horario> listaCursoHorario) {
		this.listaCursoHorario = listaCursoHorario;
	}

	@PrePersist
	@PreUpdate
	public void beforeSaveOrUpdate() {
		this.fechaRegistro = LocalDateTime.now();
	}

}
