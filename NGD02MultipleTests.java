package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NGD02MultipleTests { // do not add public void main when creating class
	
	@Test (priority = 1)  /// setting the priority will execute this test first
	public void testAmazon() 
	{
		WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		  
		  driver.get("https://www.amazon.in/");
		  
		  System.out.println(driver.getTitle());
		  driver.close();
		  
	}
	// adding another test to it...
	
	@Test (priority = 4)// this is mandatory else it will not work
	public void testMyntra()
	{
		WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		  
		  driver.get("https://www.myntra.com/");
		  
		  System.out.println(driver.getTitle());
		  driver.close();
		
		
	}
	
	// adding another test to it...
	
		@Test (priority = 3)// this is mandatory else it will not work
		public void testAjio()
		{
			WebDriver driver = new ChromeDriver();
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
			  
			  driver.get("https://www.ajio.com/");
			  
			  System.out.println(driver.getTitle());
			  driver.close();
			
			
		}
		
		// adding another test to it...
		
		@Test (priority = 2)// this is mandatory else it will not work
		public void testMeesho()
		{
			WebDriver driver = new ChromeDriver();
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
			  
			  driver.get("https://www.meesho.com/");
			  
			  System.out.println(driver.getTitle());
			  driver.close();
			
			
		}// here test cases are executed in alphabetical order..that is why testAjio was executed first.set priority in the 
		 // test to avoid that.
}

