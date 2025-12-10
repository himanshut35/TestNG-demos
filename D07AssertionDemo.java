package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.testng.Assert;



public class D07AssertionDemo {
	
	WebDriver driver;
	
	  @Test(dataProvider = "LoginData")
	  public void f(String un, String ps) {
		 
		  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);
		  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ps);
		  driver.findElement(By.xpath("//button[@type='submit']")).submit();
		  
		  /* when we see the console , it shows as passed for every credentials whether we are logging in
		   * successfully or not...it shows because that case is executed successfully..
		   * to show the test case where login failed as FAILED..we have to use ASSERTION
		   * import org.testng.Assert;*/
		  
		 //Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));// it will give assertion error
		// we can write the msg as well
		  Assert.assertTrue(driver.getPageSource().contains("dashboard"), "Invalid credentials");
		 
		 
	  }
	  
	  @DataProvider
	  public Object[][] LoginData() {
	    return new Object[][] {
	      new Object[] { "admin", "admin123" },
	      new Object[] { "himanshu", "tomar" },
	      new Object[] { "Akash", "tomar" },
	      new Object[] { "Lavish", "tomar" },
	      new Object[] { "admin", "admin123" },
	    };
	  }
	  
	  @AfterMethod
	  public void afterMethod() {
		  if(driver.getCurrentUrl().contains("dashboard")) { 
		  System.out.println("login pass");
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p")).click();
		  driver.findElement(By.partialLinkText("Log")).click();
		  }
		  else {
			  System.out.println("login fail");
		  }
	  }

	  
	  @BeforeTest
	  public void beforeTest() {
		  driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  }

	  @AfterTest
	  public void afterTest() throws InterruptedException {
		  Thread.sleep(2000);
		 // driver.close();
	  }
	}



