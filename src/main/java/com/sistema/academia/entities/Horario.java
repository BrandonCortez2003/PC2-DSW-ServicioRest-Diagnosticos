package com.sistema.academia.entities;

import java.sql.Time;
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
@Table(name="tb_horario")
public class Horario {

	@Id
	@Column(name="cod_horario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="dia_semana")
	private String diaSemana;
	
	@Column(name="hora_ini_horario")
	private Time horaIni;
	
	@Column(name="hora_fin_horario")
	private Time horaFin;
	
	@Column(name="estado_horario")
	private Boolean estado;
	
	@Column(name="fecha_registro")
	@CreationTimestamp
	private LocalDateTime fechaRegistro;
	
	//Relacion con nivel detalle Curso 
	@ManyToOne
	@JoinColumn(name="cod_nivel_detalle_curso")
	private NivelDetalleCurso niveldetallecurso;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Time getHoraIni() {
		return horaIni;
	}

	public void setHoraIni(Time horaIni) {
		this.horaIni = horaIni;
	}

	public Time getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
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

	public NivelDetalleCurso getNiveldetallecurso() {
		return niveldetallecurso;
	}

	public void setNiveldetallecurso(NivelDetalleCurso niveldetallecurso) {
		this.niveldetallecurso = niveldetallecurso;
	}
	
	
	@PrePersist
	@PreUpdate
	public void beforeSaveOrUpdate() {
		this.fechaRegistro = LocalDateTime.now();
	}
	
}
