package com.qa.hotels.tests;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.Case1;
import com.qa.hotels.pages.Case2;
import com.qa.hotels.pages.Star4;


public class Star4Test {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	Case1 case1;
	Case2 case2;
	Star4 star4;
	
	
	@BeforeTest
	public void setUp() throws InterruptedException {

		basePage=new BasePage();
		prop=basePage.init_properties();
		String browserName=prop.getProperty("browser");
		driver=basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		case1 = new Case1(driver);
		case2 = case1.goCase2();
		star4=case2.goStar4();
		Thread.sleep(3000);
	}	
@Test (priority=1 ,enabled=true)
	
	public void verifyIsFour() throws InterruptedException {
	//boolean text = star4.IsFourStarsInTenMiles();
     // System.out.println(text);
     // Assert.assertTrue(text);
     // Thread.sleep(3000);
	System.out.println(star4.IsFourStarsInTenMiles());
      }



	@AfterTest
	public void tearDown() {
	driver.quit();	
	}
	
	
	
	
	
}
