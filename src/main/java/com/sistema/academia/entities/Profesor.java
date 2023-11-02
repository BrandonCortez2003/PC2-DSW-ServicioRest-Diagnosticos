package com.sistema.academia.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_profesor")
public class Profesor {
	
	@Id
	@Column(name="cod_prof")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name = "nom_prof")
	private String nombre;
	
	@Column(name = "ape_prof")
	private String apellido;
	
	@Column(name = "edad_prof")
	private String edad;
	
	@Column(name = "esta_prof")
	private String estado;
	
	@Column(name = "dni_prof")
	private String dni;
	
	@Column(name = "fono_prof")
	private String fono;
	
	@Column(name = "dire_prof")
	private String direccion;
	
	
	@Column(name = "mail_prof")
	private String mail;
	
	@Column(name = "fec_nac_prof")
	private LocalDate fecNac;
	
	
	@Column(name = "fec_reg_prof")
	private LocalDate fecReg;


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


	public String getEdad() {
		return edad;
	}


	public void setEdad(String edad) {
		this.edad = edad;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
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


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public LocalDate getFecNac() {
		return fecNac;
	}


	public void setFecNac(LocalDate fecNac) {
		this.fecNac = fecNac;
	}


	public LocalDate getFecReg() {
		return fecReg;
	}


	public void setFecReg(LocalDate fecReg) {
		this.fecReg = fecReg;
	}


	
	
	

}
