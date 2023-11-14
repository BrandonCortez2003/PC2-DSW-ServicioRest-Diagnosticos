package com.sistema.academia.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_usuario")
	private int codigo;
	
	@Column(name="login")
	private String login;
	
	@Column(name = "password")
	private String clave;
	
	@Column(name="nom_usu")
	private String nombre;
	
	@Column(name="ape_usu")
	private String apellido;
	
	@Column(name="correo_usu")
	private String correo;
	
	@Column(name="dni_usu")
	private String dni;
	
	@Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

	
	@ManyToOne
	@JoinColumn(name="idrol")
	private Rol rol;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaRegistro;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaRegistro = fechaCreacion;
	}
	
	
	@PrePersist
    protected void onCreate() {
		fechaRegistro = LocalDateTime.now();
    }

	
	
}
