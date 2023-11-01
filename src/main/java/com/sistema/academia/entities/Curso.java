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
@Table(name="tb_curso")
public class Curso {
	
	@Id
	@Column(name="cod_curs")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="nom_curs")
	private String nombre;
	
	@Column(name="hora_inicio_curs")
	private String horaini;
	
	@Column(name="hora_final_curs")
	private String horafin;
	
	@Column(name="secc_curs")
	private String seccion;
	
	@Column(name="vaca_curs")
	private Integer vacantes;
	
	@Column(name="vaca_libre_curs")
	private Integer vacantesLibre;
	
	
	//Relacion
	@ManyToOne
	@JoinColumn(name="turn_curs")
	private TurnoCurso turnoCurs;
	
	@ManyToOne
	@JoinColumn(name="tipo_curs")
	private TipoCurso tipoCurs;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHoraini() {
		return horaini;
	}

	public void setHoraini(String horaini) {
		this.horaini = horaini;
	}

	public String getHorafin() {
		return horafin;
	}

	public void setHorafin(String horafin) {
		this.horafin = horafin;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public Integer getVacantes() {
		return vacantes;
	}

	public void setVacantes(Integer vacantes) {
		this.vacantes = vacantes;
	}

	public Integer getVacantesLibre() {
		return vacantesLibre;
	}

	public void setVacantesLibre(Integer vacantesLibre) {
		this.vacantesLibre = vacantesLibre;
	}

	public TurnoCurso getTurnoCurs() {
		return turnoCurs;
	}

	public void setTurnoCurs(TurnoCurso turnoCurs) {
		this.turnoCurs = turnoCurs;
	}

	public TipoCurso getTipoCurs() {
		return tipoCurs;
	}

	public void setTipoCurs(TipoCurso tipoCurs) {
		this.tipoCurs = tipoCurs;
	}
	
	
	
	
	
	
	

}
