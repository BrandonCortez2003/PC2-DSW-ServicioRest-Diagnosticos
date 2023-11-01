package com.sistema.academia.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sistema.academia.entities.Enlace;
import com.sistema.academia.services.UsuarioServices;

@SessionAttributes("ENLACES")
@Controller
@RequestMapping("/sesion")
public class UsuarioController {
	@Autowired
	private UsuarioServices servicioUsu;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/intranet")
	public String intranet(Authentication auth, Model model) {
		String nomRol = auth.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(","));
		List<Enlace> lista = servicioUsu.traerEnlacesDelUsuario(nomRol);
		model.addAttribute("ENLACES", lista);
		return "intranet";
	}
}
