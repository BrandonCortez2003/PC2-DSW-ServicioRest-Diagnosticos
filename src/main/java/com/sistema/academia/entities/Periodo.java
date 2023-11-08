package com.sistema.academia.entities;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_periodo")
public class Periodo {

	@Id
	@Column(name="IdPeriodo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="Descripcion")
	private String descripcion;
	
	@Column(name="FechaInicio")
	private Date fechaIni;
	
	@Column(name="FechaFin")
	private Date fechafin;
	
	@Column(name="Activo")
	private Boolean estado;
	
	
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

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
	
	
	
	
}
