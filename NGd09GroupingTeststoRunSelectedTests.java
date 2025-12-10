package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NGd09GroupingTeststoRunSelectedTests {
	/*<?xml version="1.0" encoding="UTF-8"?>
	<suite name="my groups">
	  <test name = "grouping">
	    <classes>
	      <class name="com.TestNGDemos.NGD09GroupingTests">
	      </class>
	    </classes>
	    <groups>
	    <run>
	     <include name="Amazonsell"></include>   ...for excluding a group.....use exclude
	    </run>
	   </groups>
	  </test>
	 </suite>
	 above code is required to be written in xml file*/
	 
		// while grouping you need to take care of adding parameter i.e alwaysRun=true...only in the case of groups.
		
	WebDriver driver;
		
		@BeforeTest (alwaysRun=true)   // remember adding while using groups
		public void beforetest() {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}
		
		@AfterTest (alwaysRun=true)
		public void aftertest() {
			driver.close();
		}
		
		@BeforeMethod (alwaysRun=true)
		public void beforemethod() {
			
			System.out.println("Before method");
			driver.get("https://www.amazon.in/");
		}
		
		@AfterMethod (alwaysRun=true)
		public void aftermethod() throws InterruptedException {
			
			System.out.println("title is : " + driver.getTitle());
			
		}
		// in case you want to execute just 50 test cases out of 200 or any number...we can use groups..
		@Test (priority=1, groups="Amazonsell")  //just add groups followed by any name..pass this name to the test case
		                                         // which you want to group it with..  
		public void clicksell() {
			driver.findElement(By.linkText("Sell")).click();
		}
		
		@Test (priority=2, groups="Amazonsell") // it will group with clicksell..x04 example
		public void bestsellers() {
			driver.findElement(By.linkText("Best Sellers")).click();
		}
		
		// what if we want to skip any test case....a)Either by commenting(//) that particular test..b) By  commenting @Test
		 // c)By writing @Test (priority=3, enabled= false)
		@Test (priority=3) // it will not execute this test
		public void mobiles() {
			driver.findElement(By.partialLinkText("Mobile")).click();
		}
		//or use exclude in xml file..
		
		@Test (priority=4)
		public void electronics() {
			driver.findElement(By.partialLinkText("Electronics")).click();
		}

}
