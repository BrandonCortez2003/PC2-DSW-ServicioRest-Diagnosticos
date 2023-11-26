package com.sistema.academia.entities;

import java.time.LocalDate;

import java.time.LocalDateTime;
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
@Table(name="tb_alumno")
public class Alumno {
	
	@Id
	@Column(name="cod_alu")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="nom_alu")
	private String nombre;
	

	@Column(name="ape_alu")
	private String apellido;

	@Column(name="sexo_alu")
	private String sexo;
	
	@Column(name="dni_alu")
	private String dni;

		
	@Column(name="dire_alu")
	private String direccion;

	@Column(name="fecha_naci_alu")
	private LocalDate fechanaci;

	
	@Column(name="fecha_registro")
	@CreationTimestamp
	private LocalDateTime fecharegi;
	
	//Relacion con distrito
	
	@ManyToOne
	@JoinColumn(name="cod_dis")
	private Distrito distrito;
	
	

	
	//Relacion con matricula
	@OneToMany(mappedBy = "alumno")
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



	public String getSexo() {
		return sexo;
	}



	public void setSexo(String sexo) {
		this.sexo = sexo;
	}





	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}




	public LocalDate getFechanaci() {
		return fechanaci;
	}



	public void setFechanaci(LocalDate fechanaci) {
		this.fechanaci = fechanaci;
	}





	public LocalDateTime getFecharegi() {
		return fecharegi;
	}



	public void setFecharegi(LocalDateTime fecharegi) {
		this.fecharegi = fecharegi;
	}



	public Distrito getDistrito() {
		return distrito;
	}



	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}






	public List<Matricula> getListaMatricula() {
		return listaMatricula;
	}



	public void setListaMatricula(List<Matricula> listaMatricula) {
		this.listaMatricula = listaMatricula;
	}



	@PrePersist
	@PreUpdate
    protected void onCreate() {
		fecharegi = LocalDateTime.now();
    }
	

	
}
