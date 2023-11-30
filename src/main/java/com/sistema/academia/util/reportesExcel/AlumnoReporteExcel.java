package com.sistema.academia.util.reportesExcel;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sistema.academia.entities.Alumno;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;



public class AlumnoReporteExcel {


	private XSSFWorkbook libro;
	private XSSFSheet hoja;
	
	
	private List<Alumno> listaAlumnos;


	public AlumnoReporteExcel(List<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
		libro = new XSSFWorkbook();
		hoja = libro.createSheet("Alumnos");
	}
	
	
	private void escribirCabecera() {
		
		Row fila = hoja.createRow(0);
		
		CellStyle estilo = libro .createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setBold(true);
		fuente.setFontHeight(16);
		estilo.setFont(fuente);
		
		Cell celda = fila.createCell(0);
		celda.setCellValue("CÓDIGO");
		celda.setCellStyle(estilo);

		celda = fila.createCell(1);
		celda.setCellValue("NOMBRE");
		celda.setCellStyle(estilo);

		 celda = fila.createCell(2);
		celda.setCellValue("APELLIDO");
		celda.setCellStyle(estilo);
		
		 celda = fila.createCell(3);
		celda.setCellValue("DNI");
		celda.setCellStyle(estilo);
		
		 celda = fila.createCell(4);
		celda.setCellValue("FECHA");
		celda.setCellStyle(estilo);
		
		 celda = fila.createCell(5);
		celda.setCellValue("SEXO");
		celda.setCellStyle(estilo);
		
		 celda = fila.createCell(6);
		celda.setCellValue("DISTRITO");
		celda.setCellStyle(estilo);
		
		 celda = fila.createCell(7);
		celda.setCellValue("DIRECCION");
		celda.setCellStyle(estilo);
		
		 celda = fila.createCell(8);
		celda.setCellValue("FECHAREGISTRO");
		celda.setCellStyle(estilo);

	}
	
	
	private void escribirDatosTabla() {
		
		int numeroFilas = 1;
		
		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setFontHeight(14);
		estilo.setFont(fuente);
		
		
		for(Alumno alumno : listaAlumnos) {
			
			Row fila = hoja.createRow(numeroFilas ++);
			
			Cell celda = fila.createCell(0);
			celda.setCellValue(alumno.getCodigo());
			hoja.autoSizeColumn(0);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(1);
			celda.setCellValue(alumno.getNombre());
			hoja.autoSizeColumn(1);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(2);
			celda.setCellValue(alumno.getApellido());
			hoja.autoSizeColumn(2);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(3);
			celda.setCellValue(alumno.getDni());
			hoja.autoSizeColumn(3);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(4);
			celda.setCellValue(alumno.getFechanaci());
			hoja.autoSizeColumn(4);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(5);
			celda.setCellValue(alumno.getSexo());
			hoja.autoSizeColumn(5);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(6);
			celda.setCellValue(alumno.getDistrito().getNombre());
			hoja.autoSizeColumn(6);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(7);
			celda.setCellValue(alumno.getDireccion());
			hoja.autoSizeColumn(7);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(8);
			celda.setCellValue(alumno.getFecharegi().toString());
			hoja.autoSizeColumn(8);
			celda.setCellStyle(estilo);
			
			
		}
		
		
		
	}
	
	public void exportar(HttpServletResponse response) throws IOException {
		
		escribirCabecera();
		escribirDatosTabla();
		
		ServletOutputStream outPutStream = response.getOutputStream();
		libro.write(outPutStream);
		
		libro.close();
		outPutStream.close();
		
		
	}
	
	
	
	
	
}
