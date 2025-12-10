package com.TestNGDemos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NGD15ReadingDataFromExcel {
	
	String fPath= "D:\\\\logindata.xlsx";
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
  //@Test - // commenting this test after using loop 
  public void getData() { // reading the data
	  row=sheet.getRow(0); /// read the row
	  cell=row.getCell(0); // read the cell
	  
	  //read the data from cell
	  cell.getStringCellValue(); //returns string value
	  System.out.println(cell.getStringCellValue());
	  
	  // we can also write above code in 1 line
	  sheet.getRow(0).getCell(0).getStringCellValue();
	  System.out.println(sheet.getRow(0).getCell(1).getStringCellValue());// it returns 1st row 2 clon i.e pasword
	  // for float value : getNumericcellvalue
	  
	  System.out.println(sheet.getRow(0).getCell(2).getStringCellValue());
	  
  }
  
  @Test
  public void getAllData() {
	  // reading all the data like above will be too hectic and code length will be high..we use loop
	  // outer loop for ROWS and inner loop for CELLS/colnms
	  
	  for(int i=0;i<7;i++) // // outewr lopp for rows...i<7 bcz there are 7 rows
		  
	  { 		  
		  row=sheet.getRow(i);
		  
		  for(int j=0;j<3;j++) // j<3 bcz there are cells in each row or 3 colnms
		  {
			  cell=row.getCell(j);
			  System.out.println(cell.getStringCellValue());
		  }
		  System.out.println("-------------------------------------------------------------------");
		  // above line is just for understanding purpose
		  
		  
	  }
	  
	  
  }
  
  // ---------------------or--------------------
  // when you dont know no of cellls and rows..or someone add the data or remove /..better to usebelow path
  
  @Test
  public void getAllDataUsingRowandCell() {
	 int tr= sheet.getPhysicalNumberOfRows();
	 int totalCells= sheet.getRow(0).getPhysicalNumberOfCells();
	 
	 for (int i=0;i < tr;i++) {
		 row=sheet.getRow(i);
		 for(int j=0;j<totalCells;j++) {
			 cell=row.getCell(j);
			 System.out.println(cell.getStringCellValue());
		 }
		 
	 }
  }
  
  @BeforeTest
  public void beforeTest() throws IOException {
	  file=new File(fPath);
	  fis=new FileInputStream(file);
	  wb=new XSSFWorkbook(fis); // whuile reading the data from workbookk pass the fileinputstream object bcz
	  // we r not supposed to create the work,...rather we r just reading the workbook which is already present.
	  
	  sheet=wb.getSheet("1sheets"); // we r reading the sheet
	  // why getsheet bcz we r not supposed to create the sheet,rather we r going to read it
	  
	  
  }

  @AfterTest
  public void afterTest() throws IOException {
	  wb.close();
	  fis.close();
  }

}

// div does not take data , input tag does...look for input tag when sending data 
