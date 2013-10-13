package com.kk.bos.poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

public class POITest {
	@Test
	public void read() {
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream("test.xls"));
			HSSFSheet sheet = workbook.getSheet("Sheet1");
			for(Row row:sheet) {
				for(Cell cell:row) {
					if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
						System.out.println(cell.getStringCellValue());
					} else {
						System.out.println(cell.getNumericCellValue());
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void write() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("testSheet");
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("hello");
		
		try {
			workbook.write(new FileOutputStream("e:/test.xls"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
