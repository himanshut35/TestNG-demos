package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NGD03Before_After_test { // we can add beforeTEst and afterTest while creating the class..just tick it
	
	WebDriver driver;
	@BeforeTest  // can use anywhere in the code
	public void beforeTest() { // you can change the name here
		//WebDriver driver = new ChromeDriver(); // we need to remove this WebDriver as there are 2 WebDriver and this is the
		// local one which is being initialised..and we are using global one which is not initialised..so just remove WebDriver
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		  System.out.println("Before test : ");
		
	}
	// not mandatory ki beforetest use kia h to aftertest b use kro
	@AfterTest
	public void afterTest() {
		driver.close();
	}
  
	@Test (priority = 1)  /// setting the priority will execute this test first
	public void testAmazon() 
	{
			   
		  driver.get("https://www.amazon.in/");  // driver is showing error..bcz the object of webdriver is created 
		  // in the object...just create a global object of Webdriver.
		  
		  System.out.println(driver.getTitle());
		 
		  
	}
	// adding another test to it...
	
	@Test (priority = 4)// this is mandatory else it will not work
	public void testMyntra()
	{
		  
		  driver.get("https://www.myntra.com/");
		  
		  System.out.println(driver.getTitle());
		
		
		
	}
	
	// adding another test to it...
	
		@Test (priority = 3)// this is mandatory else it will not work
		public void testAjio()
		{			  
			  driver.get("https://www.ajio.com/");
			  
			  System.out.println(driver.getTitle());
			  	
			
		}
		
		// adding another test to it...
		
		@Test (priority = 2)// this is mandatory else it will not work
		public void testMeesho()
		{
					  
			  driver.get("https://www.meesho.com/");
			  
			  System.out.println(driver.getTitle());
			  
			
			
		}// here test cases are executed in alphabetical order..that is why testAjio was executed first.set priority in the 
		 // test to avoid that.
}


