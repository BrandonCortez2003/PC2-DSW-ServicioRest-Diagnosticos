package com.sistema.academia.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_cursoprofesor")

public class CursoProfesor {
	
	@Id
	@Column(name="cod_cursprof")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	
	
	//relacion
	@ManyToOne
	@JoinColumn(name="cod_prof")
	private Profesor codigoPro;
	
	@ManyToOne
	@JoinColumn(name="cod_curs")
	private Curso codigoCur;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Profesor getCodigoPro() {
		return codigoPro;
	}

	public void setCodigoPro(Profesor codigoPro) {
		this.codigoPro = codigoPro;
	}

	public Curso getCodigoCur() {
		return codigoCur;
	}

	public void setCodigoCur(Curso codigoCur) {
		this.codigoCur = codigoCur;
	}
	
	
	
	
	

}
