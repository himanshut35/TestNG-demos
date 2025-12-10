package com.TestNGDemos;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NGD14APOM_PageFactory { //23-9: Page Factory is the collection of WebElements u r using in your script
	// we r trying to call all/required controls at once.
	
	//---------------PAGE OBJECT MODEL---------------------VERY IMP
	// creating multiple methods for implementing the logic of script and calling those methods whenever required.

	
		WebDriver driver;
		
		// using page factory-----need to use in capstone project.
		@FindBy (id="login1") WebElement usrnme; //find the webelement by id = login1  and store it in username
		//or anything ..we can also use access specifier ..public/private Webelement usrname;
		@FindBy (id="password") WebElement password;//find the webelement by id = password  and store it in password
		
	
		// so we donnt have to write all this all over again, we can just call these methods
	
	
		
	/*public void configurations() {  purposely not using in next file
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}	*/
	
	 //creating constructor --refer next file----rightclk-source-create constructor using fields 
	 public NGD14APOM_PageFactory(WebDriver driver) {
		    //need to pass pagefactory here to work..
		 PageFactory.initElements(driver, this);
			//generating constructor to set connctn btw 2 classes
			this.driver = driver;
		}
	
	//creatinng different methods for each step.and we can recall them
	public void openSite() {
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	}



	public void username(String un) {
		//driver.findElement(By.id("login1")).sendKeys(un);
		usrnme.sendKeys(un); // use this now as we have stored it in username
	}
	
	public void password(String ps) {
		//driver.findElement(By.id("password")).sendKeys(ps); // delete this when suiung pgfctry after storing it  in password
		password.sendKeys(ps);
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

