package com.sistema.academia.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_nivel_detalle")
public class NivelDetalle {

	@Id
	@Column(name="IdNivelDetalle")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="TotalVacantes")
	private Integer vacantes_total;
	
	@Column(name="VacantesDisponibles")
	private Integer vacantes_disponibles;
	
	@Column(name="VacantesOcupadas")
	private Integer vacantes_ocupadas;
	
	@Column(name="Activo")
	private Boolean estado;

	@Column(name="FechaRegistro")
	private LocalDate fec_reg;

	
	@ManyToOne
	@JoinColumn(name = "IdNivel")
	private Nivel nivel;
	
	@ManyToOne
	@JoinColumn(name = "IdGradoSeccion")
	private GradoSeccion gradoseccion;
	

	@JsonIgnore
	@OneToMany(mappedBy = "detalle")
	private List<Matricula> listaDetalle;

	public List<Matricula> getListaDetalle() {
		return listaDetalle;
	}

	public void setListaDetalle(List<Matricula> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getVacantes_total() {
		return vacantes_total;
	}

	public void setVacantes_total(Integer vacantes_total) {
		this.vacantes_total = vacantes_total;
	}

	public Integer getVacantes_disponibles() {
		return vacantes_disponibles;
	}

	public void setVacantes_disponibles(Integer vacantes_disponibles) {
		this.vacantes_disponibles = vacantes_disponibles;
	}

	public Integer getVacantes_ocupadas() {
		return vacantes_ocupadas;
	}

	public void setVacantes_ocupadas(Integer vacantes_ocupadas) {
		this.vacantes_ocupadas = vacantes_ocupadas;
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

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public GradoSeccion getGradoseccion() {
		return gradoseccion;
	}

	public void setGradoseccion(GradoSeccion gradoseccion) {
		this.gradoseccion = gradoseccion;
	}
	
	
}
