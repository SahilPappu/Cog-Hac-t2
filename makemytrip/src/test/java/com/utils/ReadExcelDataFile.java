package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ReadExcelDataFile { // Class to read Excel file
	XSSFWorkbook wb; // XSSFWorkbook object
	XSSFSheet sheet; // XSSFSheet object

	public ReadExcelDataFile() { // Setup FileInputStream in InputValues.xlsx
		try {
			File src = new File(System.getProperty("user.dir") + "\\Resources\\ExcelSheets\\InputData.xlsx");
			// Path to InputData.xlsx
			FileInputStream fis = new FileInputStream(src); // FileInputStream object

			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheetAt(0); // opens sheet(0)/default sheet

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getStringCellData(int row, int column) { // get cell data
		return sheet.getRow(row).getCell(column).getStringCellValue(); // Getting cell data from InputValues.xlsx
	}

	public long getNumericCellData(int row, int column) { // get cell data
		return (long) sheet.getRow(row).getCell(column).getNumericCellValue(); // Getting cell data from InputValues.xlsx
	}

}