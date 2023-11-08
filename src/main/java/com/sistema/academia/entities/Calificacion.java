package com.sistema.academia.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_calificacion")
public class Calificacion {

	
	@Id
	@Column(name="IdCalificacion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="Nota")
	private String nota;
	
	@Column(name="Activo")
	private boolean activo;
	
	@Column(name="FechaRegistro")
	private String registro;
	
	//Relacion
			@ManyToOne
			@JoinColumn(name="IdCurricula")
			private Curricula curricula;
			
			@ManyToOne
			@JoinColumn(name="IdAlumno")
			private Alumno alumno;

			public Integer getCodigo() {
				return codigo;
			}

			public void setCodigo(Integer codigo) {
				this.codigo = codigo;
			}

			public String getNota() {
				return nota;
			}

			public void setNota(String nota) {
				this.nota = nota;
			}

			public boolean isActivo() {
				return activo;
			}

			public void setActivo(boolean activo) {
				this.activo = activo;
			}

			public String getRegistro() {
				return registro;
			}

			public void setRegistro(String registro) {
				this.registro = registro;
			}

			public Curricula getCurricula() {
				return curricula;
			}

			public void setCurricula(Curricula curricula) {
				this.curricula = curricula;
			}

			public Alumno getAlumno() {
				return alumno;
			}

			public void setAlumno(Alumno alumno) {
				this.alumno = alumno;
			}
			
}
