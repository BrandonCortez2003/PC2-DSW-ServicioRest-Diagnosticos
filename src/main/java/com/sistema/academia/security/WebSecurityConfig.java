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
				.requestMatchers("/sesion/**","resources/**","/css/**","/img/**").permitAll()
				.requestMatchers("/director/**","/profesor/**","/cursos/**","/cursosalumno/**","/cursoprofesor/**").authenticated()
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
