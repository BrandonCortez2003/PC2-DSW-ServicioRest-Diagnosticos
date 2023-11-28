package com.sistema.academia.entities;


import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private LocalTime horaIni;
	
	@Column(name="hora_fin_horario")
	private LocalTime horaFin;
	

	
	//Relacion con nivel detalle Curso 
	@ManyToOne
	@JoinColumn(name="cod_nivel")
	private Nivel nivel;
	
	@ManyToOne
	@JoinColumn(name="cod_seccion")
	private Seccion seccion;
	
	@ManyToOne
	@JoinColumn(name="cod_curso")
	private Curso curso;
	
	

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



	public LocalTime getHoraIni() {
		return horaIni;
	}

	public void setHoraIni(LocalTime horaIni) {
		this.horaIni = horaIni;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	
	

}
