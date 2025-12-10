package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NGD14POM_CLIENT {
	// taking reference from NGD13POM_Client...it was class a and now this is class b and it is that we will
	// take reference from there.. one class is : NGD13POM_Client and now second class is NGD14POM_CLIENT.
	// second class will take reference from the first class...and generally second class is testng class
	
	WebDriver driver;// all opertns/methods needs to be perform on this driver object...so the webdriver object from the  
	// this file need to be assigned to previous file to use it..set connctn btw these 2 classes
	//means we have to tell that POM_Client driver = POM_CLIENT driver
	// create a constructor in the first class...right click anywhere-source-generate constructor using fields 
	// in the first class.
	
	// we have to call the object of POM_client class from the previous file, so recalling that below
	NGD13POM_Client c1; 
	
	
  @Test
  public void testLogin() {
	  c1.username("him  ");
	  //c1.password("jijj");
	  c1.signIn();
	  c1.handleAlert();
  }
  
  @Test
  public void testLogin2() {// we can try different data
	  
	  c1.username("tomar  ");
	  //c1.password("jijj");
	  c1.signIn();
	  c1.handleAlert();
  }
  
  @Test(dataProvider="getuserName")//passing getusername here to read the data from here
  public void testLogin3(String un) {// we can try different data
	  
	  c1.username(un);
	  //c1.password("jijj");
	  c1.signIn();
	  c1.handleAlert();
  }
  
  @DataProvider //  23-09,8:35 around
  public Object[][] getuserName(){
	  return new Object[][] {   //// 2 square braces means return typ is 2d array..
			  new Object[] {"admin"},
			  new Object[] {"nfdfnv"},
			  new Object[] {"djdkkfv"},
			  new Object[] {"tomar"},
	  };
  }
  
  @BeforeMethod
  public void BeforeMethod() throws InterruptedException {
	  driver.findElement(By.id("login1")).clear(); // here we cleared the textbox to enter another value
	  Thread.sleep(3000);
  }
  
  
  @BeforeTest()
  public void beforeTest() {
	  driver = new ChromeDriver(); //it will launch the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		c1=new NGD13POM_Client(driver);// passing this driver object to the constructor
		
		c1.openSite();
  }
  
  @AfterTest()
  public void afterTest() throws InterruptedException {
	  Thread.sleep(3000);
	  c1.driverclose();
	  
  }
}
