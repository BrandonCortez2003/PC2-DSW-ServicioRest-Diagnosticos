package com.sistema.academia.entities;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_periodo")
public class Periodo {

	@Id
	@Column(name="cod_perio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="des_perio")
	private String descripcion;
	
	@Column(name="fecha_ini_perio")
	private LocalDate fechaIni;
	
	@Column(name="fecha_fin_perio")
	private LocalDate fechafin;
	
	@Column(name="estado_perio")
	private Boolean estado;
	

	@Column(name="fecha_registro")
	private LocalDateTime fechaRegistro;
	
	
	//Relacion
	@OneToMany(mappedBy = "periodo")
	private List<Nivel> listaNivel;
	

	
	@JsonIgnore
	@OneToMany(mappedBy = "periodo") 
	private List<Nivel> listaPeriodo;
	

	public List<Nivel> getListaPeriodo() {
		return listaPeriodo;
	}

	public void setListaPeriodo(List<Nivel> listaPeriodo) {
		this.listaPeriodo = listaPeriodo;
	}


	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(LocalDate fechaIni) {
		this.fechaIni = fechaIni;
	}

	public LocalDate getFechafin() {
		return fechafin;
	}

	public void setFechafin(LocalDate fechafin) {
		this.fechafin = fechafin;
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
	
	
	
	
	public List<Nivel> getListaNivel() {
		return listaNivel;
	}

	public void setListaNivel(List<Nivel> listaNivel) {
		this.listaNivel = listaNivel;
	}

	@PrePersist
    protected void onCreate() {
		fechaRegistro = LocalDateTime.now();
    }
	
	
	
}
