package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NGD13PageObjectModel {
	//---------------PAGE OBJECT MODEL---------------------VERY IMP
	// creating multiple methods for implementing the logic of script and calling those methods whenever required.

	
		WebDriver driver;
		
	//creating main method to call the below methods
	public static void main(String[] args) throws InterruptedException {
	NGD13PageObjectModel r1=new NGD13PageObjectModel(); //creating object of class..pass the clas name used while creating class
		r1.configurations();
		r1.openSite();
		r1.username("himanshu");
		r1.password("Himanshut35@");
		r1.signIn();
		r1.handleAlert();
		r1.driverclose();
		r1.Waiting();
		
		//now for using different data and create another object and we can just call it..reusability
		NGD13PageObjectModel r2=new NGD13PageObjectModel(); //creating object of class..pass the clas name used while creating class
		r2.configurations();
		r2.openSite();
		r2.username("tomar");
		r2.password("Himanshut35@");
		r2.signIn();
		r2.handleAlert();
		r2.driverclose();
		
	}	
	// so we donnt have to write all this all over again, we can just call these methods
	
	
		
	public void configurations() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
