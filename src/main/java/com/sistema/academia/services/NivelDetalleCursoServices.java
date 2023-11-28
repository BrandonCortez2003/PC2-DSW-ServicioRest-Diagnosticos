package com.sistema.academia.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.academia.entities.NivelDetalleCurso;
import com.sistema.academia.entities.NivelDetalleCursoPK;
import com.sistema.academia.repository.NivelDetalleCursoRepository;

@Service
public class NivelDetalleCursoServices {
	
	
	@Autowired
	private NivelDetalleCursoRepository repoDetalleCurso;
	
	@Transactional
	public void registrarNivCurso(NivelDetalleCurso det, List<NivelDetalleCurso> detalle) {
		
		try {
			
			for(NivelDetalleCurso detalleItem : detalle ) {
				
				NivelDetalleCursoPK pk = new NivelDetalleCursoPK();
				pk.setCod_nivel(det.getNivel().getCodigo());
				pk.setCod_seccion(det.getSeccion().getCodigo());
				pk.setCod_curso(detalleItem.getCurso().getCodigo());
				detalleItem.setPK(pk);
				
				repoDetalleCurso.save(detalleItem);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

    public List<Map<String, Object>> obtenerCursosPorNivelYSeccion(Integer codNivel, Integer codSeccion) {
        List<Object[]> codigosNombresCursos = repoDetalleCurso.findCodigosNombresCursosByNivelAndSeccion(codNivel, codSeccion);
        List<Map<String, Object>> cursos = new ArrayList<>();

        for (Object[] codNombreCurso : codigosNombresCursos) {
            Map<String, Object> curso = new HashMap<>();
            curso.put("codigo", codNombreCurso[0]); 
            curso.put("nombre", codNombreCurso[1]); 
            cursos.add(curso);
        }

        return cursos;
    }


}
