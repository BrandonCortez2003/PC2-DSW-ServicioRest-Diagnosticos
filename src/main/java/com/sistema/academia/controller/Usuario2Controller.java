package com.sistema.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistema.academia.entities.Rol;
import com.sistema.academia.entities.Usuario;
import com.sistema.academia.services.RolServices;
import com.sistema.academia.services.UsuarioServices;

@SessionAttributes("ENLACES")
@Controller
@RequestMapping("/usuario")
public class Usuario2Controller {
	@Autowired
	private UsuarioServices servicioUsu;
	
	@Autowired
	private RolServices servicioRol;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	
	@RequestMapping("/lista")

	public String index(Model model) {
		// Atributos
		model.addAttribute("usuario", servicioUsu.listarTodos());
		model.addAttribute("rol", servicioRol.listarTodos());
		return "usuario";
	}
	
	
	

	// @RequestParam, permite recuperar valores que se encuentran en los controles
	// del formulario
	// (cajas, checkbox, radio, etc)
	@RequestMapping("/grabar")
	public String grabar(
			@RequestParam("codigo") Integer codigo, 
			@RequestParam("nombre")String nombre,
			@RequestParam("apellido")String apellido,
			@RequestParam("correo")String correo,
			@RequestParam("dni")String dni,
			@RequestParam("rol") int codRol,
            @RequestParam("login") String login,
            @RequestParam("password") String clave,
						RedirectAttributes redirect) {

		try {
			Usuario usu = new Usuario();
			usu.setNombre(nombre);
			usu.setApellido(apellido);
			usu.setCorreo(correo);
			usu.setDni(dni);
			usu.setLogin(login);
	        usu.setClave(encoder.encode(clave));
			Rol rol = new Rol();
			rol.setCodigo(codRol);
			usu.setRol(rol);
			if (codigo==0) {
			servicioUsu.registrar(usu);
			redirect.addFlashAttribute("MENSAJE", "Usuario registrado");
			}
			else {
				usu.setCodigo(codigo);
				servicioUsu.actualizar(usu);
				redirect.addFlashAttribute("MENSAJE","Usuario actualizado");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/usuario/lista";
	}

	@RequestMapping("/buscar")
	
	public Usuario buscar(@RequestParam("codigo") Integer cod) {
		return servicioUsu.buscarPorID(cod);

	}
	
	// Crear ruta o direccion URL para eliminar medicamento según código
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("codigo") Integer cod,RedirectAttributes redirect) {
		servicioUsu.eliminarPorID(cod);
		redirect.addFlashAttribute("MENSAJE","Usuario eliminado");
		return "redirect:/usuario/lista";
	}
	
	
    
    // Otros métodos del controlador

	 
}
	
	
	
