package com.sistema.academia.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_grado_seccion")
public class GradoSeccion {

	@Id
	@Column(name="IdGradoSeccion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="DescripcionGrado")
	private String descripGrado;
	
	@Column(name="DescripcionSeccion")
	private String descripSeccion;
	
	@Column(name="Activo")
	private Boolean estado;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripGrado() {
		return descripGrado;
	}

	public void setDescripGrado(String descripGrado) {
		this.descripGrado = descripGrado;
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
	
	
	
}
