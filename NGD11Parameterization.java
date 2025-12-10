package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NGD11Parameterization {
	/*suppose the client has given us xml  file for data...x06..less used 
	 <suite name="my groups">
  <test name = "groupoing">
    <classes>
      <class name="com.TestNGDemos.NGD11Parameterization">
      </class>
    </classes>
    <parameters>
      <parameter name="himanshu" value="himan"></parameter>  ...in the name give any name
      <parameter name="tomar" value="tom123"></parameter>
      </parameters>
  </test>
 </suite>
	 */
	WebDriver driver;
	
	// must add annotation from org....
  @Parameters({"himanshu","tomar"})  //..pass those parameters name here..
		
  @Test
  public void login(String un,String ps) { // it means that read the value of parameter "himanshu" and store in un
		                                   // and read the value of parameter "tomar" and store in ps
	  
	  driver.findElement(By.id("username")).sendKeys(un);
	  driver.findElement(By.id("password")).sendKeys(ps);
	  driver.findElement(By.id("submit")).click();
  }
  
  // if we want to test with multiple tests and data@Parameters({"himanshu1","tomar1"})  //..pass those parameters name here..
  @Parameters({"himanshu1","tomar1"})	
@Test
public void login1(String un,String ps) { // it means that read the value of parameter "himanshu" and store in un
	                                   // and read the value of parameter "tomar" and store in ps

driver.findElement(By.id("username")).sendKeys(un);
driver.findElement(By.id("password")).sendKeys(ps);
driver.findElement(By.id("submit")).click();
}
  
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.findElement(By.linkText("Log out")).click();
  }

  @BeforeClass
  public void beforeClass() {
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  driver.get("https://practicetestautomation.com/practice-test-login/");
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.close();
  }

}
