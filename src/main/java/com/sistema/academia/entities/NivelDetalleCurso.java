package com.sistema.academia.entities;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_nivel_detalle_curso")
public class NivelDetalleCurso {

	@EmbeddedId
	private NivelDetalleCursoPK PK;
	
	
	@ManyToOne
	@JoinColumn(name="cod_nivel", insertable = false,
			updatable = false,
			referencedColumnName ="cod_nivel")
	private Nivel nivel;
	
	@ManyToOne
	@JoinColumn(name="cod_seccion", insertable = false,
			updatable = false,
			referencedColumnName ="cod_seccion")
	private Seccion seccion;
	
	
	
	//Relacion con curso
	@ManyToOne
	@JoinColumn(name="cod_curso", insertable = false,
			updatable = false,
			referencedColumnName ="cod_curso")
	private Curso curso;



	public NivelDetalleCursoPK getPK() {
		return PK;
	}



	public void setPK(NivelDetalleCursoPK pK) {
		PK = pK;
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



	public Curso getCurso() {
		return curso;
	}



	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	

}
