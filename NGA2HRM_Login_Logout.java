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

public class NGA2HRM_Login_Logout {
	
	WebDriver driver;
  @Test
  public void login1() {
	  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  // button have type=submit than we can also use .submit() instead of .click()
  }
  @BeforeMethod
  public void beforeMethod() {
	  
  }
  
  // we can do it for another user also..just create a test and provide username and password..
  // keep logout functionality as aftermethod when you are verifying for multiple users else you will have
  // to write the code everytime.
  @Test
  public void login2() {
	  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("himanshu");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Himanshuntomar");
	  driver.findElement(By.xpath("//button[@type='submit']")).submit();
	 
  }
  
  /* it will throw nosuchelementexception() for invalid credentials..as login1 will be successfully logged in
     and successfully logged out..but when login2 will come,,there are invalid credentials..till login it is ok
     but than aftermethod will also run and as the credentials are wrong , it will not login..therefore it will give
     the exception.because that logout control will not be visible .........................
     to avoid this , use if condition...*/

  @AfterMethod
  public void afterMethod() {/* we can also write the below code in test...setting priority =2...but we want to
	   execute the logout after every login...for single login it is ok but for multiple users, put it as aftermethod
	  */ 
	  if(driver.getCurrentUrl().contains("dashboard")) { /* it means that after login if the url has dashboard in it
		  it will execute below code and if not it will execute the else part..after login currenturl changes.
		  Now we can try for as much data as we want..valid / invalid ..*/
	  System.out.println("login pass");
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p")).click();
	  driver.findElement(By.partialLinkText("Log")).click();
	  }
	  else {
		  System.out.println("login fail");
	  }
  }
  
  @Test
  public void login3() {
	  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("tomar");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("tomarg");
	  driver.findElement(By.xpath("//button[@type='submit']")).submit();
	 
  }
  
  @Test
  public void login4() {
	  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
	  driver.findElement(By.xpath("//button[@type='submit']")).submit();
	 
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
