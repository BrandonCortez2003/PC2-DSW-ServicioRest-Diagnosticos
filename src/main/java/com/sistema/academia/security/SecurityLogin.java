package com.sistema.academia.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sistema.academia.entities.Usuario;
import com.sistema.academia.services.UsuarioServices;

public class SecurityLogin implements UserDetailsService{


	@Autowired
	private UsuarioServices servicioUsu;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserDetails bean = null;
		Usuario usu= servicioUsu.iniciarSesion(username);
		//Rol del usuario
		Set<GrantedAuthority> rol = new HashSet<GrantedAuthority>();
		rol.add(new SimpleGrantedAuthority(usu.getRol().getDescripcion()));
		//Crear bean
		bean = new User(username, usu.getClave(), rol);
		
		return bean;
	}

}
