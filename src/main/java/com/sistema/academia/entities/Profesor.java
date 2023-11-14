package com.sistema.academia.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_docente")
public class Profesor {
	
	@Id
	@Column(name="cod_doc")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name = "nom_doc")
	private String nombre;
	
	@Column(name = "ape_doc")
	private String apellido;
	
	@Column(name = "estado_doc")
	private Boolean estado;
	
	@Column(name = "dni_doc")
	private String dni;
	
	@Column(name="sexo_doc")
	private String sexo;
	
	@Column(name="grado_estudio_doc")
	private String gradoStudio;
	
	@Column(name = "telef_doc")
	private String fono;
	
	@Column(name = "direc_doc")
	private String direccion;
	
	@Column(name = "correo_doc")
	private String correo;
	
	@Column(name = "fecha_naci_doc")
	private LocalDate fecNacimiento;
	
	
	@Column(name = "fecha_registro")
	private LocalDateTime fecReg;

	
	//Relacion 
	@ManyToOne
	@JoinColumn(name="cod_dis")
	private Distrito distrito;


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


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getGradoStudio() {
		return gradoStudio;
	}


	public void setGradoStudio(String gradoStudio) {
		this.gradoStudio = gradoStudio;
	}


	public String getFono() {
		return fono;
	}


	public void setFono(String fono) {
		this.fono = fono;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public LocalDate getFecNacimiento() {
		return fecNacimiento;
	}


	public void setFecNacimiento(LocalDate fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}


	public LocalDateTime getFecReg() {
		return fecReg;
	}


	public void setFecReg(LocalDateTime fecReg) {
		this.fecReg = fecReg;
	}


	public Distrito getDistrito() {
		return distrito;
	}


	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	

	


	
	
	

}
