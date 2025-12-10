package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NGD14POM_PAGEFACTORY { // Page Factory is the collection of WebElements u r using in your script
	
	
	WebDriver driver;
	// we have to call the object of POM_PageFactory class from the previous file, so recalling that below
	NGD14APOM_PageFactory c1; 
	
	
  @Test
  public void testLogin() {
	  c1.username("him  ");
	  //c1.password("jijj");
	  c1.signIn();
	  c1.handleAlert();
  }
  
  @BeforeTest()
  public void beforeTest() {
	  driver = new ChromeDriver(); //it will launch the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		c1=new NGD14APOM_PageFactory(driver);// passing this driver object to the constructor
		
		c1.openSite();
  }
  
  @AfterTest()
  public void afterTest() {
	  c1.driverclose();
	  
  }
}


