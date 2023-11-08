package com.sistema.academia.entities;

import java.sql.Time;
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
@Table(name="tb_nivel")
public class Nivel {

	@Id
	@Column(name="IdNivel")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="DescripcionNivel")
	private String desc_nivel;
	
	@Column(name="DescripcionTurno")
	private String desc_turno;
	
	@Column(name="HoraInicio")
	private Time hora_inicio;
	
	@Column(name="HoraFin")
	private Time hora_fin;
	
	@Column(name="Activo")
	private Boolean estado;

	@Column(name="FechaRegistro")
	private LocalDate fec_reg;
	
	
	@ManyToOne
	@JoinColumn(name = "IdPeriodo")
	private Periodo periodo;

	@JsonIgnore
	@OneToMany(mappedBy = "nivel")
	private List<NivelDetalle> listaNivel;

	public List<NivelDetalle> getListaNivel() {
		return listaNivel;
	}


	public void setListaNivel(List<NivelDetalle> listaNivel) {
		this.listaNivel = listaNivel;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getDesc_nivel() {
		return desc_nivel;
	}


	public void setDesc_nivel(String desc_nivel) {
		this.desc_nivel = desc_nivel;
	}


	public String getDesc_turno() {
		return desc_turno;
	}


	public void setDesc_turno(String desc_turno) {
		this.desc_turno = desc_turno;
	}


	public Time getHora_inicio() {
		return hora_inicio;
	}


	public void setHora_inicio(Time hora_inicio) {
		this.hora_inicio = hora_inicio;
	}


	public Time getHora_fin() {
		return hora_fin;
	}


	public void setHora_fin(Time hora_fin) {
		this.hora_fin = hora_fin;
	}


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	public LocalDate getFec_reg() {
		return fec_reg;
	}


	public void setFec_reg(LocalDate fec_reg) {
		this.fec_reg = fec_reg;
	}


	public Periodo getPeriodo() {
		return periodo;
	}


	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

}
