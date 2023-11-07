package com.sistema.academia.entities;

import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_horario")
public class Horario {

	@Id
	@Column(name="IdHorario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="DiaSemana")
	private String diaSemana;
	
	@Column(name="HoraInicio")
	private Time horaIni;
	
	@Column(name="HoraFin")
	private Time horaFin;
	
	@Column(name="Activo")
	private Boolean estado;
	
}
