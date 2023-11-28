package com.sistema.academia.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.academia.entities.NivelDetalle;
import com.sistema.academia.entities.NivelDetallePk;
import com.sistema.academia.repository.NivelDetalleRepository;



@Service
public class NivelDetalleServices {
		
	@Autowired
	private NivelDetalleRepository repoNivelDet;
	
	@Transactional
	public void registrarNivelSec(NivelDetalle det, List<NivelDetalle> detalle) {
		
		try {
			for (NivelDetalle detalleItem : detalle) {
                NivelDetallePk pk = new NivelDetallePk();
                pk.setCod_nivel(det.getNivel().getCodigo()); 
                pk.setCod_seccion(detalleItem.getSeccion().getCodigo()); 
                detalleItem.setPk(pk);

                repoNivelDet.save(detalleItem);
            }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	




		


}	
		
		
	
	
	
	
	



