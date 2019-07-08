package com.filta.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData
{
	private Sheet Sheet1;
	private Workbook Wb;
	private File File_Obj;
	private FileInputStream Input;
	private int TotlaRows;
	private int TotalCol;

	public ReadExcelData(String Path, String SheetName)
	{
		File_Obj = new File(Path);
		try
		{
			Input = new FileInputStream(File_Obj);
			Wb = new XSSFWorkbook(Input);
			Sheet1 = Wb.getSheet(SheetName);
			Wb.close();
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public ReadExcelData(String Path, int Index)
	{
		File_Obj = new File(Path);
		try
		{
			Input = new FileInputStream(File_Obj);
		     Wb = new XSSFWorkbook(Input);
			Sheet1 = Wb.getSheetAt(Index);
			Wb.close();
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public int getTotalRows()
	{
		// For Only One Row Use: int totlaRows = sheet1.getLastRowNum() + 1;
		TotlaRows = Sheet1.getLastRowNum();
		return TotlaRows;
	}


	public int getTotalColumns()
	{
		TotalCol = Sheet1.getRow(0).getLastCellNum();
		return TotalCol;
	}


	public String getCellData(int RowNum, int ColNum)
	{
		return Sheet1.getRow(RowNum).getCell(ColNum).getStringCellValue();
	}


	public double getCellDataInt(int RowNum, int ColNum)
	{
		return Sheet1.getRow(RowNum).getCell(ColNum).getNumericCellValue();
	}
}
