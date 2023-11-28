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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_seccion")
public class Seccion {

	@Id
	@Column(name="cod_seccion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="des_seccion")
	private String descripSeccion;
	
	@Column(name="vaca_seccion")
	private Integer vacante;
	
	@Column(name="estado_seccion")
	private Boolean estado;	
	
	@Column(name="fecha_registro")
	@CreationTimestamp
	private LocalDateTime fechaRegistro;

	
	@JsonIgnore
	//Relacion con nivel detalle
		@OneToMany(mappedBy = "seccion")
		private List<NivelDetalle> listaNivelDetalle;
		
	
	//Relacion con Nivel Detalle Curso
	@JsonIgnore
	@OneToMany(mappedBy = "seccion")
	private List<NivelDetalleCurso> listaNivelDetalleCurso;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "seccion")
	private List<Horario> listaSeccionHorario;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "seccion")
	private List<Matricula> listaSeccionMatricula;
	
	
	public Seccion() {
		
	}
	
	
	public Seccion(Integer codigo) {
		this.codigo=codigo;
	}



	public Integer getCodigo() {
			return codigo;
		}



		public void setCodigo(Integer codigo) {
			this.codigo = codigo;
		}



		public String getDescripSeccion() {
			return descripSeccion;
		}



		public void setDescripSeccion(String descripSeccion) {
			this.descripSeccion = descripSeccion;
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



		public List<NivelDetalle> getListaNivelDetalle() {
			return listaNivelDetalle;
		}



		public void setListaNivelDetalle(List<NivelDetalle> listaNivelDetalle) {
			this.listaNivelDetalle = listaNivelDetalle;
		}

		
		
		


	public Integer getVacante() {
			return vacante;
		}


		public void setVacante(Integer vacante) {
			this.vacante = vacante;
		}

		
		
		

	public List<NivelDetalleCurso> getListaNivelDetalleCurso() {
			return listaNivelDetalleCurso;
		}


		public void setListaNivelDetalleCurso(List<NivelDetalleCurso> listaNivelDetalleCurso) {
			this.listaNivelDetalleCurso = listaNivelDetalleCurso;
		}


		
		
		
	public List<Horario> getListaSeccionHorario() {
			return listaSeccionHorario;
		}


		public void setListaSeccionHorario(List<Horario> listaSeccionHorario) {
			this.listaSeccionHorario = listaSeccionHorario;
		}

		
		
		

	public List<Matricula> getListaSeccionMatricula() {
			return listaSeccionMatricula;
		}


		public void setListaSeccionMatricula(List<Matricula> listaSeccionMatricula) {
			this.listaSeccionMatricula = listaSeccionMatricula;
		}


	@PrePersist
	@PreUpdate
	public void beforeSaveOrUpdate() {
		this.fechaRegistro = LocalDateTime.now();
	}
}
