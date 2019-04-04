package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	Sheet sheet1;

	public ReadExcelData(String path, String SheetName) {
		File file = new File(path);
		try {
			FileInputStream input = new FileInputStream(file);
			Workbook wb = new XSSFWorkbook(input);
			sheet1 = wb.getSheet(SheetName);
			wb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ReadExcelData(String path, int index) {
		File file = new File(path);
		FileInputStream input;
		try {
			input = new FileInputStream(file);
			Workbook wb = new XSSFWorkbook(input);
			sheet1 = wb.getSheetAt(index);
			wb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getTotalRows() {
		// For Only One Row Use: int totlaRows = sheet1.getLastRowNum() + 1;
		int totlaRows = sheet1.getLastRowNum();
		return totlaRows;
	}

	public int getTotalColumns() {
		int totalCol = sheet1.getRow(0).getLastCellNum();
		return totalCol;
	}

	public String getCellData(int rowNum, int colNum) {
		return sheet1.getRow(rowNum).getCell(colNum).getStringCellValue();
	}

	public double getCellDataInt(int rowNum, int colNum) {
		return sheet1.getRow(rowNum).getCell(colNum).getNumericCellValue();
	}
}
