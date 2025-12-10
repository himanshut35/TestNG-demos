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

public class D08ModularFramework {
	/*what if there are 200 tests and we want ton execute only 20...we will not comment or enable=false the remaining
	  180 tests...here we use MODULAR FRAMWEORK.
	  MODULAR FRAMEWORK --(a). Used for executing or skipping single/multiple test cases.
	                      (b). Executing test cases via XML file.
	                      
	  POINTS TO BE NOTED WHILE CREATING XML FILE- (a).All tags are predefined.
	                                              (b).All tags are case sensitive.
	                                              (c).Can not alter sequence of any tag.
	                                              
	               XML FILE
	               <?xml version="1.0" encoding="UTF-8"?>
<suite name="My suite"> ... here give any name
  <test name="My test">....her egive any name
    <classes>
      <class name="com.NGassignments.NGA01Amazon"> ....package.className
        <methods>
          <include name="bestsellers"></include> ....include name= give the name of your test that you want to run
          <include name="clicksell"></include>  ...<exclude name="clicksell"></exclude> for excluding the test  
        </methods> 
       </class>
    </classes>
  </test>
</suite>       
-----------------------------------------------refer x01,x03.
alsom we can run all the tests using xml file....just remove methods and include/exclude.
can execute 2 class also..just give class names. 
we can use 2 classes method when checking for 2 functionalities that are linked to each other..*/
	
WebDriver driver;
	
	@BeforeTest
	public void beforetest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterTest
	public void aftertest() {
		driver.close();
	}
	
	@BeforeMethod
	public void beforemethod() {
		
		System.out.println("Before method");
		driver.get("https://www.amazon.in/");
	}
	
	@AfterMethod
	public void aftermethod() throws InterruptedException {
		
		System.out.println("title is : " + driver.getTitle());
		
	}
	// in case you want to execute just 50 test cases out of 200 or any number...we can use groups..
	@Test (priority=1, groups="Amazonsell")  //just add groups follwed by any namee..pass this name to the test case
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
	@Test (priority=3, enabled=false) // it will not execute this test
	public void mobiles() {
		driver.findElement(By.partialLinkText("Mobile")).click();
	}
	//or use exclude in xml file..
	
	@Test (priority=4)
	public void electronics() {
		driver.findElement(By.partialLinkText("Electronics")).click();
	}


}
