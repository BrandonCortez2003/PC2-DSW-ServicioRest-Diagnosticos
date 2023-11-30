package com.sistema.academia.util.reportesExcel;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sistema.academia.entities.Matricula;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class MatriculaReporteExcel {


	private XSSFWorkbook libro;
	private XSSFSheet hoja;
	
	private List<Matricula> listaMatricula;

	public MatriculaReporteExcel(List<Matricula> listaMatricula) {
		this.listaMatricula = listaMatricula;
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
		celda.setCellValue("ALUMNO");
		celda.setCellStyle(estilo);

		 celda = fila.createCell(2);
		celda.setCellValue("NIVEL");
		celda.setCellStyle(estilo);
		
		 celda = fila.createCell(3);
		celda.setCellValue("SECCION");
		celda.setCellStyle(estilo);
		
		 celda = fila.createCell(4);
		celda.setCellValue("APODERADO");
		celda.setCellStyle(estilo);
		
		 celda = fila.createCell(5);
		celda.setCellValue("COLEGIO PROCEDENCIA");
		celda.setCellStyle(estilo);
		
		 celda = fila.createCell(6);
		celda.setCellValue("FECHA REGISTRO");
		celda.setCellStyle(estilo);
		
	}
		
		private void escribirDatosTabla() {
			
			int numeroFilas = 1;
			
			CellStyle estilo = libro.createCellStyle();
			XSSFFont fuente = libro.createFont();
			fuente.setFontHeight(14);
			estilo.setFont(fuente);
			
			for(Matricula matricula : listaMatricula) {
				
				Row fila = hoja.createRow(numeroFilas ++);
				
				Cell celda = fila.createCell(0);
				celda.setCellValue(matricula.getCodigo());
				hoja.autoSizeColumn(0);
				celda.setCellStyle(estilo);
				
				celda = fila.createCell(1);
				celda.setCellValue(matricula.getAlumno().getNombre());
				hoja.autoSizeColumn(1);
				celda.setCellStyle(estilo);
				
				celda = fila.createCell(2);
				celda.setCellValue(matricula.getNivel().getNivel());
				hoja.autoSizeColumn(2);
				celda.setCellStyle(estilo);
	
				celda = fila.createCell(3);
				celda.setCellValue(matricula.getSeccion().getDescripSeccion());
				hoja.autoSizeColumn(3);
				celda.setCellStyle(estilo);
				
				celda = fila.createCell(4);
				celda.setCellValue(matricula.getApoderado().getNombre());
				hoja.autoSizeColumn(4);
				celda.setCellStyle(estilo);
				
				celda = fila.createCell(5);
				celda.setCellValue(matricula.getInstitutoPro());
				hoja.autoSizeColumn(5);
				celda.setCellStyle(estilo);
				
				celda = fila.createCell(6);
				celda.setCellValue(matricula.getFechaRegistro());
				hoja.autoSizeColumn(6);
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
