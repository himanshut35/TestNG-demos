package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class NGD15DataDrivenFrmwrkWriteDatatoExcel {
	// Data Driven Framework - read/write using excel files.

	// what is a excel file
	// workbook(excel file)- collection of sheets
	// sheets - collection of rows
	// row - collection  of cells
	// cell- it contains the data

	//Apache POI(Poor obfuscation implementation) act as an API btw selenium and excel file

	//handling excel file - while handling excel file,keep in in mind about the sequence of objects u r using
	//workbook-sheet-row-cell ...this should be the flow 

	// create object of type file in java - inputstream/outputstream...inpst to read data,otpstrm to write the data
	//download apache poi...after downloading copy it in webdriver jar files(created in beginning) and unzip it.
	// copy the 21 files into the project..how to do it..
	// select the project-right click-build path-configure build path-select libraries-classpath-add external jar files
	// and click on apply and close.
	
	//at first create file object...remember configuring jar files of Apache ROI.....23/9
	// create in sequence
	File file;
	FileOutputStream fos; // outputstream to write the data
	XSSFWorkbook wb;     //name of object is XSFFWorkbook-XSSF =XML SpreadSheet Format(use for .xlsx file),HSSF for.xls
	                   // hSSF = horrible spreadsheet format
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	// above are declared ..now need to initialise them...need to initialise only once and in beforeTest
	
	  @BeforeTest
	  public void beforeTest() throws FileNotFoundException {
		  //initializing 
		  file=new File("D:\\MyFirstExcelFile.xlsx");//need to give name and path of file..if path is not given file will
		  // be added in your projectfolder....it willll now store the file in Dfolder.
		  fos=new FileOutputStream(file); // passing file object to it
		  wb=new XSSFWorkbook();
		  sheet=wb.createSheet("FirstSheet"); // it will create a sheet in the wb workbook
		  
	  }
	
  @Test
  public void writeData() { // data can be entered many times
	  
	  row=sheet.createRow(0); //create 1st(0) row inside the sheet
	  cell=row.createCell(0); // create 1st cell inside first row
	  //adding the data
	  cell.setCellValue("Himanshu");
	  
	  //assignment task..name of your friends
	  
	 // row=sheet.createRow(0); //create 1st(0) row inside the sheet
	  cell=row.createCell(1); // create 1st cell inside first row
	  //adding the data
	  cell.setCellValue("tomar");
	  
	  row=sheet.createRow(1); 
	  cell=row.createCell(0); 	  
	  cell.setCellValue(" Ishan");
	  //row=sheet.createRow(1); 
	  cell=row.createCell(1); 	  
	  cell.setCellValue(" Lomas");
	  
	  row=sheet.createRow(2); 
	  cell=row.createCell(0); 	  
	  cell.setCellValue("Lavish ");
	  //row=sheet.createRow(2); 
	  cell=row.createCell(1); 	  
	  cell.setCellValue("Moral");
	  
  }//refer NGA03 Exceldata in assgnmnts

  @AfterTest
  public void afterTest() throws IOException {
	  //now practically the data is in wb workbook but we need to store it physically. how to do it
	  wb.write(fos); // it will write the data to file...very imp..wont work without this
	  // we r writing it at the end as if we need to enter more data we can add and at last call this
	  System.out.println("Data added in file");
	  wb.close(); //closing workbook
	  fos.close(); // file task is closed
  }
// refresh the project and a new file be added to it by the name given above...in test-output.MyFirstExcelFile.xlsx
  // can also see in the folder if the path is not given...physiclly..in your workspace
  
  
}
