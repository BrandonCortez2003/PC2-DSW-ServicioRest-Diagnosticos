package com.sistema.academia.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistema.academia.entities.Enlace;
import com.sistema.academia.entities.Rol;
import com.sistema.academia.entities.Usuario;
import com.sistema.academia.services.UsuarioServices;

@SessionAttributes("ENLACES")
@Controller
@RequestMapping("/sesion")
public class UsuarioController {
	@Autowired
	private UsuarioServices servicioUsu;
	
	@Autowired
	private UsuarioServices servicioRol;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "registrarse";
	}
	
	@GetMapping("/existeDni/{dni}")
    public ResponseEntity<Boolean> existeDni(@PathVariable String dni) {
        boolean existe = servicioUsu.existeDni(dni);
        return ResponseEntity.ok(existe);
    }
	

	@RequestMapping("/intranet")
	public String intranet(Authentication auth, org.springframework.ui.Model model) {
		String nomRol = auth.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(","));
		
		List<Enlace> lista = servicioUsu.traerEnlacesDelUsuario(nomRol);
		model.addAttribute("ENLACES", lista);
		return "intranet";
	}
	

	    
	@PostMapping("/sesion/registrarse")
	public ResponseEntity<String> registrarUsuario(@RequestBody Usuario usuario) {
	    // Verificar si el DNI ya existe en la base de datos
	    boolean dniExistente = servicioUsu.existeDni(usuario.getDni());

	    if (dniExistente) {
	        return ResponseEntity.badRequest().body("El DNI ya está en uso.");
	    } else {
	        // Lógica para guardar el usuario en la base de datos
	    	servicioUsu.guardarUsuario(usuario);
	        return ResponseEntity.ok("Usuario registrado exitosamente.");
	    }
	}
	
	@RequestMapping("/registrarse")
	public String grabar (
						@RequestParam("nombre")String nombre,
						@RequestParam("apellido")String apellido,
						@RequestParam("correo")String correo,
						@RequestParam("dni")String dni,
	                    @RequestParam("login") String login,
	                    @RequestParam("password") String clave,
	                   
	                
	                    RedirectAttributes redirect)
	{

	    try {
	        // Crear objeto de la entidad Usuario
	        Usuario usu = new Usuario();
	        // Setear atributos 
	      
	        usu.setNombre(nombre);
	        usu.setApellido(apellido);
	        usu.setCorreo(correo);
	        usu.setDni(dni);
	        usu.setLogin(login);
	        usu.setClave(encoder.encode(clave));
	        
	        String mensaje = servicioUsu.guardarUsuario(usu);
	        
	        //craer objeto en la entidad rol
	        Rol rol = new Rol();
	        
	        rol.setCodigo(1);
	        
	        usu.setRol(rol);
	       
	        // Validar parametro
	        servicioUsu.registrar(usu);
	        redirect.addFlashAttribute("MENSAJE",mensaje);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return "redirect:/sesion/login";
	}
	
}