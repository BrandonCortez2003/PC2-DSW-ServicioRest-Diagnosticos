package com.sistema.academia.services;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sistema.academia.entities.NivelDetalle;
import com.sistema.academia.repository.NivelDetalleRepository;



@Service
public class NivelDetalleServices {
		
	@Autowired
	private NivelDetalleRepository repoNivelDet;
	

	public void registrar(NivelDetalle detalle)
	{
		repoNivelDet.save(detalle);
	}
	
	
	public void eliminarPoID (Integer cod )
	{
		repoNivelDet.deleteById(cod);
	}
	
	public NivelDetalle buscarPorID(Integer cod)
	{
		return repoNivelDet.findById(cod).orElse(null);
	}
	
	public List<NivelDetalle> listarTodos()
	{
		return repoNivelDet.findAll();
	}
	




		


}	
		
		
	
	
	
	
	



