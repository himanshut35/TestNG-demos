package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NGD01FirstTest {
	
  @Test // error earlier thn click on it and select add tstng library
  // testng class doesnt have any main method..rather it has test method/test case
  public void OpenFacebook() {  /// here OpenGoogle is the method which represents the test case.we can give any name accrdngly
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
	  
	  driver.get("https://www.facebook.com/");
	  
	  System.out.println(driver.getTitle());
  }
}
