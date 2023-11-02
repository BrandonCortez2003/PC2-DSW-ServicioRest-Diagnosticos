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
@Table(name="tb_cursoalumno")
public class CursoAlumno {

	@Id
	@Column(name="cod_cursalum")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	
	@Column(name="prom_cursalum")
	private String promedio;
	@Column(name="asis_cursalum")
	private String asistencia;
	@Column(name="falt_cursalum")
	private String faltas;
	
	//Relacion
		@ManyToOne
		@JoinColumn(name="cod_alum")
		private Alumno alumno;
		
		//Relacion
		@ManyToOne
		@JoinColumn(name="cod_curs")
		private Curso curso;

		public Integer getCodigo() {
			return codigo;
		}

		public void setCodigo(Integer codigo) {
			this.codigo = codigo;
		}


		public String getPromedio() {
			return promedio;
		}

		public void setPromedio(String promedio) {
			this.promedio = promedio;
		}

		public String getAsistencia() {
			return asistencia;
		}

		public void setAsistencia(String asistencia) {
			this.asistencia = asistencia;
		}

		public String getFaltas() {
			return faltas;
		}

		public void setFaltas(String faltas) {
			this.faltas = faltas;
		}

		public Alumno getAlumno() {
			return alumno;
		}

		public void setAlumno(Alumno alumno) {
			this.alumno = alumno;
		}

		public Curso getCurso() {
			return curso;
		}

		public void setCurso(Curso curso) {
			this.curso = curso;
		}
		
		
}
