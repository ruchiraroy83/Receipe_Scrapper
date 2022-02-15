package com.scrapper.qa.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Utilities {
	public FileInputStream fi;
	public FileOutputStream fo;
	String path;
	Workbook workbook;
	Sheet sheet;
	Row row;
	Cell cell;
	public Utilities(String path) {
		this.path = path;
	}

	public int getRowCount(String xlFile, String xlSheet) throws IOException {
		Workbook workbook;
		Sheet sheet;

		fi = new FileInputStream(xlFile);
		workbook = WorkbookFactory.create(fi);
		sheet = workbook.getSheet(xlSheet);
		int rowCount = sheet.getLastRowNum();
		System.out.println("Rowcount" + rowCount);

		workbook.close();
		fi.close();
		return rowCount;
	}

	public int getCellCount(String xlFile, String xlSheet, int rowNum) throws IOException {
		Workbook workbook;
		Sheet sheet;
		Row row;
		fi = new FileInputStream(xlFile);
		workbook = WorkbookFactory.create(fi);
		sheet = workbook.getSheet(xlSheet);
		row = sheet.getRow(rowNum);
		int columnCount = row.getLastCellNum();
		System.out.println("ColumnCount" + columnCount);
		workbook.close();
		fi.close();
		return columnCount;
	}

	public String getCellData(String xlFile, String xlSheet, int rowNum, int columnNum) throws IOException {
		Workbook workbook;
		Sheet sheet;
		Row row;
		Cell cell;
		fi = new FileInputStream(xlFile);
		workbook = WorkbookFactory.create(fi);
		sheet = workbook.getSheet(xlSheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(columnNum);
		String data;
		try {

			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);

		} catch (Exception e) {
			data = "";
		}

		workbook.close();
		fi.close();
		return data;
	}

	
	public void setCellData(String sheetName,int rowNum,int columnNum,String data) throws IOException
	{
		File xlfile=new File(path);
		if(!xlfile.exists())
		{
			workbook=new XSSFWorkbook();;
			fo = new FileOutputStream(path);
			workbook.write(fo);
		}
		fi = new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		
		if(workbook.getSheetIndex(sheetName)==-1)
			workbook.createSheet(sheetName);
		sheet=workbook.getSheet(sheetName);
		
		if(sheet.getRow(rowNum)==null)
		sheet.createRow(rowNum);
		row=sheet.getRow(rowNum);
		
		cell=row.createCell(columnNum);
		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fo.close();
		fi.close();

	}
	
	
}
