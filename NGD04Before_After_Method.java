package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
// while creating class just select annotations 
public class NGD04Before_After_Method {
 
	WebDriver driver;
	@BeforeTest  // can use anywhere in the code
	public void beforeTest() { 
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		  System.out.println("Before test : ");
		
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
	}
	
	 @BeforeMethod // whatever code you want to run before every test
	  public void beforeMethod() {
		 
		  System.out.println("\tBefore method"); // \t is for tab..spacing
	  }

	  @AfterMethod //// whatever code you want to run after every test
	  public void afterMethod() {
		  System.out.println("\t\t title is: " + driver.getTitle());
		  System.out.println("\tAfter method");
	  }
  
	@Test (priority = 1)  
	public void testAmazon() 
	{			   
		  driver.get("https://www.amazon.in/"); 		  
		  	 
		  
	}	
		@Test (priority = 4)
	public void testMyntra()
	{
		  
		  driver.get("https://www.myntra.com/"); 
					}
	
		@Test (priority = 3)
		public void testAjio()
		{			  
			  driver.get("https://www.ajio.com/");				 			  	
			
		}				
		@Test (priority = 2)
		public void testMeesho()
		{					  
			  driver.get("https://www.meesho.com/");			  
			 				}
}
