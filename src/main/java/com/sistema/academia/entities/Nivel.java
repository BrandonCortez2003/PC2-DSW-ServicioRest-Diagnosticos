package com.sistema.academia.entities;



import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
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
@Table(name="tb_nivel")
public class Nivel {

	@Id
	@Column(name="cod_nivel")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="des_nivel")
	private String nivel;
	
	@Column(name="des_turno")
	private String turno;
	
	@Column(name="hora_ini_nivel")
	private LocalTime horaIni;
	
	@Column(name="hora_fin_nivel")
	private LocalTime horaFin;
	
	@Column(name="estado_nivel")
	private Boolean estado;
	
	@Column(name="fecha_registro")
	@CreationTimestamp
	private LocalDateTime fecharegi;
	
	//Relacion con periodo
	@ManyToOne
	@JoinColumn(name="cod_perio")
	private Periodo periodo;
	
	
	@JsonIgnore
	//Relacion con nivel detalle
	@OneToMany(mappedBy = "nivel")
	private List<NivelDetalle> listaNivelDetalle;
	
	
	//Relacion con nivel detalle curso
	@JsonIgnore
	@OneToMany(mappedBy = "nivel")
	private List<NivelDetalleCurso> listaNivelDetalleCurso;
	
	@JsonIgnore
	@OneToMany(mappedBy = "nivel")
	private List<Horario> listaNivelHorario;
	
	@JsonIgnore
	@OneToMany(mappedBy = "nivel")
	private List<Matricula> listaNivelMatricula;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public LocalTime getHoraIni() {
		return horaIni;
	}

	public void setHoraIni(LocalTime horaIni) {
		this.horaIni = horaIni;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public LocalDateTime getFecharegi() {
		return fecharegi;
	}

	public void setFecharegi(LocalDateTime fecharegi) {
		this.fecharegi = fecharegi;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public List<NivelDetalle> getListaNivelDetalle() {
		return listaNivelDetalle;
	}

	public void setListaNivelDetalle(List<NivelDetalle> listaNivelDetalle) {
		this.listaNivelDetalle = listaNivelDetalle;
	}
	
	
	
	
	
	public List<NivelDetalleCurso> getListaNivelDetalleCurso() {
		return listaNivelDetalleCurso;
	}

	public void setListaNivelDetalleCurso(List<NivelDetalleCurso> listaNivelDetalleCurso) {
		this.listaNivelDetalleCurso = listaNivelDetalleCurso;
	}

	
	

	public List<Horario> getListaNivelHorario() {
		return listaNivelHorario;
	}

	public void setListaNivelHorario(List<Horario> listaNivelHorario) {
		this.listaNivelHorario = listaNivelHorario;
	}

	
	
	
	public List<Matricula> getListaNivelMatricula() {
		return listaNivelMatricula;
	}

	public void setListaNivelMatricula(List<Matricula> listaNivelMatricula) {
		this.listaNivelMatricula = listaNivelMatricula;
	}

	@PrePersist
	@PreUpdate
    protected void onCreate() {
		fecharegi = LocalDateTime.now();
    }



}
