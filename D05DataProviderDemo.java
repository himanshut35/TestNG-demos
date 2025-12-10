package com.TestNGDemos;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

/*
 * What if there are 200-300 users and you have to perform testing..in that case use DATA DRIVEN TESTING.
   DATA DRIVEN TESTING - executing single test case multiple times with multiple data set.
      (a)using array(@DATAPROVIDER) - this method sends the data to  test case in the form of 2D array.
   add dataprovider annotation while creating the class.*/
 
       // b. using xml file....c. using exxcel file
  
   // use ctrl +A and than ctrl+i for alignment

public class D05DataProviderDemo {
	
	@Test(dataProvider = "dp") // dp indicates that this test case is going to read the data from method dp..below
	                           // we can change this and set as per the below wriiten method.
	public void loginToHRM(Integer n, String s , String s2) { //initially it was f..we chnged it to loginToHRM
		System.out.println(n + "--> " + s + s2);
	}
	@BeforeMethod 
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}


	@DataProvider
	public Object[][] dp() { // we can change this dp and write whatever we want,but make sure to pass it above. v
		return new Object[][] {
			new Object[] { 1, "a" , "" },// it will execute as per the no of new objects..same times..
			new Object[] { 2, "b" , ""},
			new Object[] { 3, "c" , "B" },// we can add 3 parameters also but will get error...method matcher exception
			//as we r passing 3 arguments but my function is accepting only 2 args..(integer n , String s)
			// we need change the method above (integer n , String s , String s1)
		};
	}
	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}
