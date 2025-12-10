package com.TestNGDemos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NGD12KeywordDrivenFramework { // reading data from .properties file/excel file
	
	/*refer MyData.Properties for it
	 * KeywordDrivenFramework is used when suppose there are multiple locators used in different tests and
	 * suppose any locator value got changed , so we will have to change that value inn each and every test.
	 * to avoid this , we can create a reference file(MyData.properties) and use it for reference. If any changes
	 * are done, we can just change the value in the reference file and automatically changes will be made in tests.
	 * use can give any name to the file...just use .properties after the name...you can create it by new-> file
	 * 
	 
	 you can give it any way..
	 ....property = value...below are all properties along with values
 url= https://www.echotrak.com/Login.aspx?ReturnUrl=%2f
usernameTextBoxName= txtCustomerID   ...can use any name any locator
passwordTextBoxXpath=//*[@id="txtPassword"]
submitbtnCSS= input[type='submit']
errorMsgId= lblMsg
	 

	  */
	
	// we can create the file anywhere,,on the desktop too ,,just give that path
	
	//if you want to handle any kind of file in java,you have to create object of type file
	File fileread;	// can give any name
	// for reading the data from the file,,
	FileInputStream fis;
	//create one more object of type properties
	Properties prop;
	
	WebDriver driver;
	
  
  @BeforeTest
  public void beforeTest() throws IOException {
// to read the file,...in the()..give path of the file..using properties of the file..file can be created anywhere
      fileread=new File("D:\\Himanshu_SeleniumDemos\\SeleniumAutomationProject\\src\\com\\TestNGDemos\\MyData.properties");
	  fis=new FileInputStream(fileread);// read data from file : fileread
	  prop=new Properties();
	  // to read the properties from the file : fileread
	  prop.load(fis); // it will load all properties from .properties file
	  
	  // just checking
	  System.out.println(prop.getProperty("url")); // it will read url from the file
	  
	  driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(prop.getProperty("url")); //...getProperty is used to get the property value from the file
		// it will open the url
  }
  
  @Test
  public void login() {
	  
	  driver.findElement(By.name(prop.getProperty("usernameTextBoxName"))).sendKeys("himanshu"); /*here use the 
	  locator as you used in the file and give that name accoridngly which you gave in file*/
	  
	  // for password we used xpath,so use xpath locator and then name
	  driver.findElement(By.xpath(prop.getProperty("passwordTextBoxXpath"))).sendKeys("tomar");
	  driver.findElement(By.cssSelector(prop.getProperty("submitbtnCSS"))).click();
  }

  @AfterTest
  public void afterTest() {//
  }

}
