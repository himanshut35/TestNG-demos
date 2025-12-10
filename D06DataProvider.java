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

public class D06DataProvider {
	WebDriver driver;
	
  
	
  @Test(dataProvider = "LoginData")
  public void f(String un, String ps) {
	 
	  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un); // un is the argument passed
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ps);// ps is the argument passed
	  driver.findElement(By.xpath("//button[@type='submit']")).submit();
	  
  }
  
  @DataProvider
  public Object[][] LoginData() {
    return new Object[][] {
      new Object[] { "admin", "admin123" }, // it iwll try with this credentials first and so on
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
