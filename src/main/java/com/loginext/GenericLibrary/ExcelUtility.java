package com.loginext.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods to read and write data into excel sheet
 * @author Dhananjaya MK
 *
 */
public class ExcelUtility {

		/**
		 * This method will write data into excel sheet
		 * @param SheetName
		 * @param Rownum
		 * @param CelNum
		 * @param value
		 * @throws Throwable
		 */
		public void writeDataIntoExcel(String SheetName, int Rownum, int CelNum, String value) throws Throwable
		{
			FileInputStream fis=new FileInputStream(IpathConstanants.ExcelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(SheetName);
			Row ro = sh.getRow(Rownum);
			Cell cel = ro.createCell(CelNum);
			 cel.setCellValue(value);
			 FileOutputStream fos=new FileOutputStream(IpathConstanants.ExcelPath);
			 wb.write(fos);
	
		}

}
	



