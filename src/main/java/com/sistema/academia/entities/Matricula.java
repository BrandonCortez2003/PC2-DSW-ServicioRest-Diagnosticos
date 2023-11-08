package com.sistema.academia.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_matricula")
public class Matricula {

	@Id
	@Column(name="IdMatricula")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="Situacion")
	private String situacion;
	
	@Column(name="InstitucionProcedencia")
	private String institucion_procedencia;
	
	@Column(name="Activo")
	private Boolean estado;

	@Column(name="FechaRegistro")
	private LocalDate fec_reg;

	
	@ManyToOne
	@JoinColumn(name = "IdAlumno")
	private Alumno alumno;
	
	@ManyToOne
	@JoinColumn(name = "IdNivelDetalle")
	private NivelDetalle niveldetalle;
	
	@ManyToOne
	@JoinColumn(name = "IdApoderado")
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

	public String getInstitucion_procedencia() {
		return institucion_procedencia;
	}

	public void setInstitucion_procedencia(String institucion_procedencia) {
		this.institucion_procedencia = institucion_procedencia;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public LocalDate getFec_reg() {
		return fec_reg;
	}

	public void setFec_reg(LocalDate fec_reg) {
		this.fec_reg = fec_reg;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public NivelDetalle getNiveldetalle() {
		return niveldetalle;
	}

	public void setNiveldetalle(NivelDetalle niveldetalle) {
		this.niveldetalle = niveldetalle;
	}

	public Apoderado getApoderado() {
		return apoderado;
	}

	public void setApoderado(Apoderado apoderado) {
		this.apoderado = apoderado;
	}
	
	
}
