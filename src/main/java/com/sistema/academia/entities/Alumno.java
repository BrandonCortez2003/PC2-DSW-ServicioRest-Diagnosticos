package com.sistema.academia.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_alumno")
public class Alumno {
	
	@Id
	@Column(name="cod_alum")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="nom_alum")
	private String nombre;
	
	@Column(name="ape_alum")
	private String apellido;
	
	@Column(name="edad_alum")
	private String edad;
	
	@Column(name="esta_Alum")
	private String estado;
	
	@Column(name="dni_alum")
	private String dni;
	
	@Column(name="fono_alum")
	private String telefono;
	
	@Column(name="dire_alum")
	private String direccion;
	
	@Column(name="mail_alum")
	private String correo;
	
	@Column(name="fec_nac_alum")
	private LocalDate fechanaci;
	
	@Column(name="fec_reg_alum")
	private LocalDate fecharegi;

	@JsonIgnore
	@OneToMany(mappedBy = "alumno")
	private List<Matricula> listaAlumno;
	
	public List<Matricula> getListaAlumno() {
		return listaAlumno;
	}

	public void setListaAlumno(List<Matricula> listaAlumno) {
		this.listaAlumno = listaAlumno;
	}

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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public LocalDate getFechanaci() {
		return fechanaci;
	}

	public void setFechanaci(LocalDate fechanaci) {
		this.fechanaci = fechanaci;
	}

	public LocalDate getFecharegi() {
		return fecharegi;
	}

	public void setFecharegi(LocalDate fecharegi) {
		this.fecharegi = fecharegi;
	}
	
	
	
	
	

	
}
