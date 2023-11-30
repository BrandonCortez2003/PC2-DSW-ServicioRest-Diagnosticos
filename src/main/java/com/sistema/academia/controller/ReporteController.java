package com.sistema.academia.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.academia.entities.Alumno;
import com.sistema.academia.entities.Matricula;
import com.sistema.academia.services.ALumnoServices;
import com.sistema.academia.services.MatriculaServices;
import com.sistema.academia.util.reportesExcel.AlumnoReporteExcel;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/reporte")
public class ReporteController {

	@Autowired
	private ALumnoServices servicioAlum;

	@Autowired
	private MatriculaServices servicioMatri;
	
	@RequestMapping("/alumno")
	public void alumno(HttpServletResponse response) {
		try {
			//invocar al método listarTodos
			List<Alumno> lista=servicioAlum.listarTodos();
			//acceder al reporte "reporteMedicamento.jrxml"
			File file=ResourceUtils.getFile("classpath:alumno.jrxml");
			//crear objeto de la clase JasperReport y manipular el objeto file
			JasperReport jasper=JasperCompileManager.compileReport(file.getAbsolutePath());
			//origen de datos "manipular lista"
			JRBeanCollectionDataSource origen=new JRBeanCollectionDataSource(lista);
			//crear reporte
			JasperPrint jasperPrint=JasperFillManager.fillReport(jasper,null,origen);
			//salida del reporte en formato PDF
			response.setContentType("application/pdf");
			
			OutputStream salida=response.getOutputStream();
			//exportar a pdf
			JasperExportManager.exportReportToPdfStream(jasperPrint,salida);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	@RequestMapping("/matricula")
	public void matricula(HttpServletResponse response) {
		try {
			//invocar al método listarTodos
			List<Matricula> lista=servicioMatri.listarTodos();
			//acceder al reporte "reporteMedicamento.jrxml"
			File file=ResourceUtils.getFile("classpath:listaMatricula.jrxml");
			//crear objeto de la clase JasperReport y manipular el objeto file
			JasperReport jasper=JasperCompileManager.compileReport(file.getAbsolutePath());
			//origen de datos "manipular lista"
			JRBeanCollectionDataSource origen=new JRBeanCollectionDataSource(lista);
			//crear reporte
			JasperPrint jasperPrint=JasperFillManager.fillReport(jasper,null,origen);
			//salida del reporte en formato PDF
			response.setContentType("application/pdf");
			
			OutputStream salida=response.getOutputStream();
			//exportar a pdf
			JasperExportManager.exportReportToPdfStream(jasperPrint,salida);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


	@RequestMapping("/exportar-alumnos-excel") 
	public void exportarAlumnosEnExcel(HttpServletResponse response) throws IOException {
	    response.setContentType("application/octet-stream");

	    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-d_HH:mm:ss");
	    String fechaActual = dateFormatter.format(new Date());

	    String cabecera = "Content-Disposition";
	    String valor = "attachment; filename=Alumnos_" + fechaActual + ".xlsx";

	    response.setHeader(cabecera, valor);

	    List<Alumno> alumnos = servicioAlum.listarTodos();

	    AlumnoReporteExcel exporter = new AlumnoReporteExcel(alumnos);
	    exporter.exportar(response);
	}

 	
	
	
}
