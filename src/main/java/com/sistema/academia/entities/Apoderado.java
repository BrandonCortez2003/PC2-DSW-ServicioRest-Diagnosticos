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
@Table(name="tb_apoderado")
public class Apoderado {

	@Id
	@Column(name="IdApoderado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="TipoRelacion")
	private String relacion;
	
	@Column(name="Nombres")
	private String nombres;
	
	@Column(name="Apellidos")
	private String apellidos;
	
	@Column(name="DocumentoIdentidad")
	private String dni;

	@Column(name="FechaNacimiento")
	private LocalDate fec_nac;
	
	@Column(name="Sexo")
	private String sexo;
	
	@Column(name="EstadoCivil")
	private String est_civ;
	
	@Column(name="Ciudad")
	private String ciudad;
	
	@Column(name="Direccion")
	private String direccion;

	@Column(name="Activo")
	private Boolean estado;

	@Column(name="FechaRegistro")
	private LocalDate fec_reg;
	

	@JsonIgnore
	@OneToMany(mappedBy = "apoderado")
	private List<Matricula> listaApoderado;

	public List<Matricula> getListaApoderado() {
		return listaApoderado;
	}

	public void setListaApoderado(List<Matricula> listaApoderado) {
		this.listaApoderado = listaApoderado;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getRelacion() {
		return relacion;
	}

	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getFec_nac() {
		return fec_nac;
	}

	public void setFec_nac(LocalDate fec_nac) {
		this.fec_nac = fec_nac;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEst_civ() {
		return est_civ;
	}

	public void setEst_civ(String est_civ) {
		this.est_civ = est_civ;
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
	
	
}
