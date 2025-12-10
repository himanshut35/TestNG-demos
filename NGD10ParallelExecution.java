package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NGD10ParallelExecution {
	
	/* what if we want to execute test cases in parallel ...refer x05
	 
<suite name="My suite" parallel="methods" thread-count="4">....//just  add : parallel="methods" thread-count="4"
	    thread-count as the no of tests...if we give thread-count as 2 it will open first 2 tests in 2 parallel and 
	    than again 2 test in parallel...
	                                                                 
 <test name="my test">
    <classes>
          <class name="com.TestNGDemos.NGD10ParallelExecution">
               </class>
     </classes>
  </test>
 </suite>
	  
	 */
  
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
			
			
		}
}
