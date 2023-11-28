package com.sistema.academia.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class NivelDetalleCursoPK {

	private int cod_nivel;
	private int cod_seccion;
	private int cod_curso;
	
	@Override
	public int hashCode() {
		return Objects.hash(cod_nivel,cod_seccion,cod_curso);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NivelDetalleCursoPK other = (NivelDetalleCursoPK) obj;
		return cod_nivel == other.cod_nivel && cod_seccion == other.cod_seccion 
				&& cod_curso == other.cod_curso;
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

	public int getCod_curso() {
		return cod_curso;
	}

	public void setCod_curso(int cod_curso) {
		this.cod_curso = cod_curso;
	}
	
	
	
	
}
