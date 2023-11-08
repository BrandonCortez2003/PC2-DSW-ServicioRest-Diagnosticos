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
	@Column(name="IdAlumno")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="Nombres")
	private String nombre;
	
	@Column(name="Apellidos")
	private String apellido;
	
	@Column(name="DNI")
	private String dni;
	
	@Column(name="FechaNacimiento")
	private LocalDate fecha;
	
	@Column(name="sexo")
	private String sexo;
	
	@Column(name="Ciudad")
	private String ciudad;
	
	@Column(name="Direccion")
	private String direccion;
	
	@Column(name="Activo")
	private boolean activo;
	
	@Column(name="FechaRegistro")
	private LocalDate registro;
	
@JsonIgnore
	
	//Relaccion
	@OneToMany (mappedBy = "alumno")
	private List<Calificacion> listaAlumno;

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

public String getDni() {
	return dni;
}

public void setDni(String dni) {
	this.dni = dni;
}

public LocalDate getFecha() {
	return fecha;
}

public void setFecha(LocalDate fecha) {
	this.fecha = fecha;
}

public String getSexo() {
	return sexo;
}

public void setSexo(String sexo) {
	this.sexo = sexo;
}

public String getCiudad() {
	return ciudad;
}

public void setCiudad(String ciudad) {
	this.ciudad = ciudad;
}

public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}

public boolean isActivo() {
	return activo;
}

public void setActivo(boolean activo) {
	this.activo = activo;
}

public LocalDate getRegistro() {
	return registro;
}

public void setRegistro(LocalDate registro) {
	this.registro = registro;
}

public List<Calificacion> getListaAlumno() {
	return listaAlumno;
}

public void setListaAlumno(List<Calificacion> listaAlumno) {
	this.listaAlumno = listaAlumno;
}

	

	
}
