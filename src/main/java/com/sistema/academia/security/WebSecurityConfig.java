package com.sistema.academia.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder encriptarClave() {
		return new BCryptPasswordEncoder();
	}

	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests((requests) -> requests
				
				.requestMatchers("/bienvenida/**","/sesion/**","/resources/**","/css/**","/img/**","/js/**").permitAll()
				.requestMatchers("/director/**","/profesor/**","/cursos/**","/periodos/**","/seccion/**","/alumno/**","/rol/**","/detalleCurso/**","/seccionNivel/**","/reporte/**").authenticated()
				

				.requestMatchers("/Admin/**").hasAnyRole("Admin")
				.requestMatchers("/Director/**").hasAnyRole("Director")
				.requestMatchers("/Secretaria/**").hasAnyRole("Secretaria")
				
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
			
				.loginPage("/sesion/login")
				.defaultSuccessUrl("/sesion/intranet")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {

		return new SecurityLogin();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		//Crear objeto
		DaoAuthenticationProvider configure = new DaoAuthenticationProvider();
		//Setear
		configure.setUserDetailsService(userDetailsService());
		configure.setPasswordEncoder(encriptarClave());
		
		return configure;
	}
	
}
