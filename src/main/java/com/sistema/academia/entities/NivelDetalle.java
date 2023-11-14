package com.sistema.academia.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_nivel_detalle")
public class NivelDetalle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_nivel_detalle")
	private Integer codigoNivelDetalle;
	
	@Column(name="total_vacantes")
	private Integer vacantes;
	
	@Column(name="vacantes_disponibles")
	private Integer vacantesDisponibles;
	
	@Column(name="vacantes_ocupadas")
	private Integer vacantesOcupadas;
	
	
	@Column(name="estado_nivel_detalle")
	private Boolean estado;
	
	@Column(name="fecha_registro")
	private LocalDateTime fechaRegistro;
	

	//Relacion con seccion
	@ManyToOne
	@JoinColumn(name="cod_seccion")
	private Seccion seccion;
	
	//Relacion con nivel
	@ManyToOne
	@JoinColumn(name="cod_nivel")
	private Nivel nivel;
	
	
	//Relacion con nivel detalle curso
	@OneToMany(mappedBy = "nivelDetalle")
	private List<NivelDetalleCurso> listaNivelDetalleCurso;
	
	
	//Relacion con matricula
	@OneToMany(mappedBy = "nivelDetalle")
	private List<Matricula> listaMatricula;
	
	


	public Integer getCodigoNivelDetalle() {
		return codigoNivelDetalle;
	}

	public void setCodigoNivelDetalle(Integer codigoNivelDetalle) {
		this.codigoNivelDetalle = codigoNivelDetalle;
	}

	public Integer getVacantes() {
		return vacantes;
	}

	public void setVacantes(Integer vacantes) {
		this.vacantes = vacantes;
	}

	public Integer getVacantesDisponibles() {
		return vacantesDisponibles;
	}

	public void setVacantesDisponibles(Integer vacantesDisponibles) {
		this.vacantesDisponibles = vacantesDisponibles;
	}

	public Integer getVacantesOcupadas() {
		return vacantesOcupadas;
	}

	public void setVacantesOcupadas(Integer vacantesOcupadas) {
		this.vacantesOcupadas = vacantesOcupadas;
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

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	
	
	public List<NivelDetalleCurso> getListaNivelDetalleCurso() {
		return listaNivelDetalleCurso;
	}

	public void setListaNivelDetalleCurso(List<NivelDetalleCurso> listaNivelDetalleCurso) {
		this.listaNivelDetalleCurso = listaNivelDetalleCurso;
	}

	public List<Matricula> getListaMatricula() {
		return listaMatricula;
	}

	public void setListaMatricula(List<Matricula> listaMatricula) {
		this.listaMatricula = listaMatricula;
	}

	@PrePersist
    protected void onCreate() {
		fechaRegistro = LocalDateTime.now();
    }
	
}
