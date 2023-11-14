package com.sistema.academia.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
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
	
	@Column(name="estado_seccion")
	private Boolean estado;	
	
	@Column(name="fecha_registro")
	private LocalDateTime fechaRegistro;
	
	
	//Relacion con nivel detalle
	@OneToMany(mappedBy = "seccion")
	private List<NivelDetalle> listaNivelDetalle;

	
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

	@PrePersist
    protected void onCreate() {
		fechaRegistro = LocalDateTime.now();
    }
	
	
	
	
}
