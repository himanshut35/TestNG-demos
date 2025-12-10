package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NGD13POM_Client {
	//---------------PAGE OBJECT MODEL---------------------VERY IMP
	// creating multiple methods for implementing the logic of script and calling those methods whenever required.

	
		WebDriver driver;
		
	//creating main method to call the below methods
	 public static void main(String[] args) throws InterruptedException {}
		// so we donnt have to write all this all over again, we can just call these methods
	
	
		
	/*public void configurations() {  purposely not using in next file
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}	*/
	
	  //creating constructor --refer next file----one more way ...refer 25/9 ---35:20
	 public NGD13POM_Client(WebDriver driver) {
			//super(); removing this object...generating constructor to set connctn btw 2 classes
			this.driver = driver;
		}
	
	//creatinng different methods for each step.and we can recall them
	public void openSite() {
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	}



	public void username(String un) {
		
		driver.findElement(By.id("login1")).sendKeys(un);
	}
	
	public void password(String ps) {
		driver.findElement(By.id("password")).sendKeys(ps);
	}
	
	public void signIn() {
		driver.findElement(By.name("proceed")).click();
	}
  
	//for handling alert , create object of class alert
	public void handleAlert() {
	Alert alt;
	alt=driver.switchTo().alert();
	System.out.println(alt.getText());
	alt.accept();
}
	public void driverclose() {
		driver.close();
	}
	
	public void Waiting() throws InterruptedException {
		Thread.sleep(5000);
		
	}
	
}
