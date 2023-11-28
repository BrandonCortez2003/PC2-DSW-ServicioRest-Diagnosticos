package com.sistema.academia.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_nivel_detalle")
public class NivelDetalle {
	
	@EmbeddedId
	private NivelDetallePk pk;
	
	
	//Relacion con nivel
	@ManyToOne
	@JoinColumn(name="cod_nivel", insertable = false,
			updatable = false,
			referencedColumnName ="cod_nivel")
	private Nivel nivel;

	//Relacion con seccion
	@ManyToOne
	@JoinColumn(name="cod_seccion",insertable = false,
			updatable = false,
			referencedColumnName ="cod_seccion")
	private Seccion seccion;
	

	
	


	public NivelDetallePk getPk() {
		return pk;
	}


	public void setPk(NivelDetallePk pk) {
		this.pk = pk;
	}


	public Nivel getNivel() {
		return nivel;
	}


	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}


	public Seccion getSeccion() {
		return seccion;
	}


	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}



	
}
