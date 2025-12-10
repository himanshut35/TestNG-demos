package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.Assert;

public class NGA03TryingbyMyself {
	
	WebDriver driver;
	
	String expUrl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	String actUrl;
	
	//( expUrl , actUrl , "not available");
		 
	@Test (dataProvider="loginData")
	public void login(String s , String p) {
		
		driver.findElement(By.name("username")).sendKeys(s);
		driver.findElement(By.name("password")).sendKeys(p);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
	}
	
	@DataProvider
	  public Object[][] loginData() {
	    return new Object[][] {
	      new Object[] { "admin", "admin123" }, // it iwll try with this credentials first and so on
	      new Object[] { "himanshu", "tomar" },
	      new Object[] { "Akash", "tomar" },
	      new Object[] { "Lavish", "tomar" },
	      new Object[] { "admin", "admin123" },
	    };
	  }
	
	@BeforeTest
	public void beforeTest() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@AfterTest
	public void afterTest() {
		
		//driver.close();
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		
	}
	
	@AfterMethod
	public void afterMethod() {
		
		actUrl = driver.getCurrentUrl();
		
		if(driver.getCurrentUrl().contains("dashboard")) {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p")).click();
		driver.findElement(By.linkText("Logout")).click();
		}
		else
			System.out.println("invalid credentials");
	}




}
