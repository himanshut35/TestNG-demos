package com.TestNGDemos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NGD15CreateLoginData { // go after NGD15DataDrivenFrmwrkWriteDatatoExcel..placed bfre 
	//25-9-24-9:07  
	
	//creating objects..also give these name only
	String fPath= "D:\\mavenexcelsssss.xlsx";
	File file;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int index=1; // to do ++ for the rows
	// starting from 1 bcz we have entered data in before test for headers
	
	
  @Test(dataProvider="getLoginData")
  public void writeData(String un,String ps,String rs) {
	  
	 // row=sheet.createRow(0); // create 1st row..it was passing all data into this one
	  row=sheet.createRow(index); 
	  cell=row.createCell(0);// create 1 cell
	  cell.setCellValue(un);// 1 cell m un
	  
	  cell=row.createCell(1);
	  cell.setCellValue(ps);
	  
	  cell=row.createCell(2);
	  cell.setCellValue(rs);
	  
	  //it will write the data in the 1 row and only last one will be available..ishan lomas123 not run
	  //bcoz we r writinng the data in the zeroth row..to avoid this declare a ineger above and do ++
	  index++;
			  
	  
	  
  }
  
  @DataProvider //  providing the data to the test
  public Object[][] getLoginData(){
	  return new Object[][] {   //// 2 square braces means return typ is 2d array..
			 // new Object[] {"username","password","Result"}, // now this is not the data..its header
		  // we have to write it in beforetest
		  
			  new Object[] {"himanshu","tomar123","not run"},
			  new Object[] {"lovish","moral123","not run"},
			  new Object[] {"keshav","panwar123","not run"},
			  new Object[] {"admin","admin123","not run"},
			  new Object[] {"ishan","lomas123","not run"},
			  //we can remove not run from here as it is same and cell=row.createCell(2); cell.setCellValue("not run");
			  // and  delete the parameter rs;..2 column of each row will contain not run
	  };
  }
	  
		
  @BeforeTest
  public void beforeTest() throws FileNotFoundException {
	  file=new File(fPath);
	  fos=new FileOutputStream(file);
	  wb=new XSSFWorkbook();
	  sheet= wb.createSheet("1sheets");
	 // sheet=wb.createSheet("2sheets"); doubt
	  
	  // for writing headers
	  //row=sheet.createRow(0); // we can also pass inndex here and do  index++ in befreTest atlast and strt index=0 above
	  //cell=row.createCell(0);
	  //cell.setCellValue("username");
	  //above 3 lines can also be written as
	  sheet.createRow(0).createCell(0).setCellValue("username");
	
	  
	  //cell=row.createCell(1);
	  //cell.setCellValue("password");
	  sheet.getRow(0).createCell(1).setCellValue("password");
	  
	  //cell=row.createCell(2);
	  // cell.setCellValue("result");
	  sheet.getRow(0).createCell(2).setCellValue("result");
	 
  }

  @AfterTest
  public void afterTest() throws IOException {
	  wb.write(fos);
	  wb.close();
	  fos.close();
  }

}
