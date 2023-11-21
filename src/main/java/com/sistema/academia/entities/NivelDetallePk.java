package com.sistema.academia.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class NivelDetallePk {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_nivel_detalle")
	private Integer codigoNivelDetalle;
	
	private int cod_nivel;
	private int cod_seccion;
	
	@Override
	public int hashCode() {
		return Objects.hash(cod_nivel, cod_seccion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NivelDetallePk other = (NivelDetallePk) obj;
		return cod_nivel == other.cod_nivel && cod_seccion == other.cod_seccion;
	}
	public Integer getCodigoNivelDetalle() {
		return codigoNivelDetalle;
	}
	public void setCodigoNivelDetalle(Integer codigoNivelDetalle) {
		this.codigoNivelDetalle = codigoNivelDetalle;
	}
	public int getCod_nivel() {
		return cod_nivel;
	}
	public void setCod_nivel(int cod_nivel) {
		this.cod_nivel = cod_nivel;
	}
	public int getCod_seccion() {
		return cod_seccion;
	}
	public void setCod_seccion(int cod_seccion) {
		this.cod_seccion = cod_seccion;
	}
	
	
}
