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
@Table(name="tb_curricula")
public class Curricula {

	@Id
	@Column(name="IdCurricula")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="Descripcion")
	private String descripcion;
	
	@Column(name="Activo")
	private boolean activo;
	
	@Column(name="FechaRegistro")
	private LocalDate registro;
	
	@ManyToOne
	@JoinColumn(name="IdCurricula")
	private NivelDetalle detalle;
	
@JsonIgnore
	
	//Relaccion
	@OneToMany (mappedBy = "curricula")
	private List<Calificacion> listaCurricula;

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

public boolean isActivo() {
	return activo;
}

public void setActivo(boolean activo) {
	this.activo = activo;
}

public LocalDate getRegistro() {
	return registro;
}

public void setRegistro(LocalDate registro) {
	this.registro = registro;
}

public NivelDetalle getDetalle() {
	return detalle;
}

public void setDetalle(NivelDetalle detalle) {
	this.detalle = detalle;
}

public List<Calificacion> getListaCurricula() {
	return listaCurricula;
}

public void setListaCurricula(List<Calificacion> listaCurricula) {
	this.listaCurricula = listaCurricula;
}

}
