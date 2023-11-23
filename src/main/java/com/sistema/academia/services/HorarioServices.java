package com.sistema.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sistema.academia.entities.Horario;
import com.sistema.academia.repository.HorarioRepository;

@Service
public class HorarioServices {

	@Autowired 
	private HorarioRepository repo;
	
	public void registrar(Horario horario) {
		repo.save(horario);
	}
	
	public void actualizar(Horario horario) {
		repo.save(horario);
	}
	
	public void eliminarPorID(Integer cod) {
		repo.deleteById(cod);
	}
	
	public Horario buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public List<Horario> listarTodos(){
		return repo.findAll();
	
	
}

}