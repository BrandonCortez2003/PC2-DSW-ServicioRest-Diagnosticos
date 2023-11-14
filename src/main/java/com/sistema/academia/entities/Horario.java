package com.sistema.academia.entities;

import java.sql.Time;
import java.time.LocalDateTime;

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
	private LocalDateTime fechaRegistro;
	
	//Relacion
	
	
}
