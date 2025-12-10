package com.TestNGDemos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NGD16LogintoOHRMviaDDF {//26-09
	/*This is divided into 3 parts
	 1. Read data from excel.
	 2.Pass this data to test case.
	 3.Update the result as pass or fail(write)
	 
	 4. we can also mark the field as colored and chnge fonnt style
	 */
	
	//1.reading data from excel..
	String fPath="D:\\frstexcl.xlsx";
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	XSSFCellStyle style; // for adding style to the cell
	XSSFFont font;// for changing font 
	FileOutputStream fos;
	int index=1;;
	
	//2 passing data to testcase
	WebDriver driver;
	
  @Test(dataProvider = "getLoginData")
  public void flogintoOHRM(String un, String ps) { // removed string rs from here as it is not needed
	  
	  System.out.println(un +"--"+ ps +"--" );// just to check
	  
	  //2.
	  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);// pass un to it
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ps);// passm ps to it
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
	  
	  
  }
  @AfterMethod // also write the  update part in AfterMethod...
  public void afterMethod() {
	  row=sheet.getRow(index);
	  cell=row.getCell(2);
	  
	  //confuguring style and font objects
	  style=wb.createCellStyle();
	  font=wb.createFont();
	  
	// check whether it is logged in or not
	  if(driver.getCurrentUrl().contains("dashboard")) {
		  System.out.println("login successful");
		  driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		  driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		  cell.setCellValue("Pass");
		  
		  //for setting color and font
		  font.setColor(HSSFColorPredefined.GREEN.getIndex()); // set color to green
		  font.setItalic(true);
		  cell.setCellStyle(style);
		  style.setFont(font);//set this font to style
	  }
	  else
	  {
		  System.out.println("LoginFailed");
		  cell.setCellValue("Fail");
		  font.setColor(HSSFColorPredefined.RED.getIndex()); // set color to green
		  font.setBold(true);
		  cell.setCellStyle(style);
		  style.setFont(font);
	  }
	  index++; // remember
  }


  @DataProvider// need to read and store the data in dataprovider from excel to use in the test to login
  public Object[][] getLoginData() {
	  int tr=sheet.getPhysicalNumberOfRows();
	  //String[][] loginData = new String[8][3]; // string [8][3] means there are 8 rows and 3 cells
	  //but what if data is added or removed
	  String[][] loginData=new String[tr-1][2]; // we can also use getPhysiclnoCell instead of 3
	  // tr-1 bcz we want only 7 rows and tr has 8 rows..exclude 1 row. changing cell = 2 as result is not need
	  
	  for(int i=0;i<tr-1;i++) //tr-1 bcoz i have to read 7 rows.. 
	  {
		for(int j=0;j<2;j++) // j<3 but here result is not needed.i.e 2
		{
			loginData[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();// i+1 bcz zero row contains
			// HEADER..we can put i=0 bcz in loginData[i][j] i will be 1 and will start writing the data at
			// 2 row..if i=1 , then in loginData[i-1][j]..or i=0 & getRow(i+1)
			// only when there is aheader..if no header ...no need to do i+1 or i-1..just strt with i=0
		}
	  }
	  return loginData;
    
  }
  @BeforeTest
  public void beforeTest() throws IOException {
	  file=new File(fPath);
	  fis=new FileInputStream(file);
	  wb=new XSSFWorkbook(fis);
	  //sheet=wb.getSheet("1sheets");
	  sheet=wb.getSheetAt(0);
	  fos=new FileOutputStream(file); //3. do not configure immediately after inputstream.file will get corrupt.
	  // at the end is good practice.
	  
	  //2. configuring driver
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  
  }

  @AfterTest
  public void afterTest() throws IOException {
	  wb.write(fos);
	  wb.close();
	  fis.close();
  }

}
