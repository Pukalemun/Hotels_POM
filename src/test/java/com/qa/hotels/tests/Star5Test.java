package com.qa.hotels.tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.Case1;
import com.qa.hotels.pages.Case2;
import com.qa.hotels.pages.Star4;
import com.qa.hotels.pages.Star5;

public class Star5Test {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	Case1 case1;
	Case2 case2;
	Star4 star4;
	Star5 star5;
	
	
	@BeforeTest
	public void setUp() throws InterruptedException {

		basePage=new BasePage();
		prop=basePage.init_properties();
		String browserName=prop.getProperty("browser");
		driver=basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		case1=new Case1(driver);
		case2 = case1.goCase2();
		star4 = case2.goStar4();
		star5 = star4.goStar5();
		star5 = new Star5(driver);
		Thread.sleep(5000);
	}	
@Test (priority=1 ,enabled=true)
	
	public void verifyIsFive() throws InterruptedException {
	
      System.out.println(star5.IsFiveStarsInTenMiles());
      
}
	@AfterTest
	public void tearDown() {
	driver.quit();	
	}
}

