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

public class NGA01Amazon {
	
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
	}
	
	@AfterMethod
	public void aftermethod() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("title is : " + driver.getTitle());
		System.out.println("After method");
	}
	
	@Test (priority=1)
	public void openbrowser() {
		driver.get("https://www.amazon.in/");
	}
	
	@Test (priority=2)
	public void clicksell() {
		driver.findElement(By.linkText("Sell")).click();
	}
	
	@Test (priority=3)
	public void openbrowseragain() {
		driver.get("https://www.amazon.in/");
	}
	
	@Test (priority=4)
	public void bestsellers() {
		driver.findElement(By.linkText("Best Sellers")).click();
	}

}
