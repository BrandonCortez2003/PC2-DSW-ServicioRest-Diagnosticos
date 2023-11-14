package com.sistema.academia.entities;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_apoderado")
public class Apoderado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_apode")
	private Integer codigo;
	
	@Column(name="nom_apode")
	private String nombre;
	
	@Column(name="ape_apode")
	private String apellido;
	
	@Column(name="rela_apode")
	private String relacionApode;
	
	@Column(name="dni_apode")
	private String dni;
	
	@Column(name="fecha_naci_apode")
	private LocalDate fechaNaci;
	
	@Column(name="sexo_apode")
	private String sexo;
	
	@Column(name="estado_civil_apode")
	private String estadoCivil;
	
	@Column(name="direc_apode")
	private String direccion;
	
	@Column(name="estado_apode")
	private Boolean estadoApode;
	
	@Column(name="fecha_registro")
	private LocalDateTime fechaRegistro;
	
	
	//Relacion
	@ManyToOne
	@JoinColumn(name="cod_dis")
	private Distrito distrito;
	
	//Relacion con alummno
	@ManyToOne
	@JoinColumn(name="cod_alu")
	private Alumno alumno;
	
	//Relacion con matricula
	@OneToMany(mappedBy = "apoderado")
	private List<Matricula> listaMatricula;
	
	

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRelacionApode() {
		return relacionApode;
	}

	public void setRelacionApode(String relacionApode) {
		this.relacionApode = relacionApode;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNaci() {
		return fechaNaci;
	}

	public void setFechaNaci(LocalDate fechaNaci) {
		this.fechaNaci = fechaNaci;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Boolean getEstadoApode() {
		return estadoApode;
	}

	public void setEstadoApode(Boolean estadoApode) {
		this.estadoApode = estadoApode;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public List<Matricula> getListaMatricula() {
		return listaMatricula;
	}

	public void setListaMatricula(List<Matricula> listaMatricula) {
		this.listaMatricula = listaMatricula;
	}
	
	
	
	
	@PrePersist
    protected void onCreate() {
		fechaRegistro = LocalDateTime.now();
    }

	
}
