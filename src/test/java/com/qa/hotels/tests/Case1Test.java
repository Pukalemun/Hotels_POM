package com.qa.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.Case1;
import com.qa.hotels.util.AppConstants;


public class Case1Test {

		WebDriver driver;
		BasePage basePage;
		Properties prop;
		Case1 case1;
		
		
		@BeforeTest
	    public void setUp() throws InterruptedException{
			
			basePage = new BasePage();
	    	prop =basePage.init_properties();
	    	String browserName = prop.getProperty("browser");
	    	driver = basePage.init_driver(browserName);
	    	driver.get(prop.getProperty("url"));
	    	case1 = new Case1(driver);
	    	Thread.sleep(3000);
		
		}
		@Test(priority=1, description="get page title  as Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations",enabled=true)
	    public void verifyPageTitleTest() throws InterruptedException{
	    	Thread.sleep(3000);
	    	String title = case1.getTitle();
	    	System.out.println("Case1 title is "+ title);
	    	Assert.assertEquals(title, AppConstants.CASE1_TITLE);
	    }
		@Test(priority=2,enabled=true)
		public void verifyGetPageHeader(){
			String header=case1.getHeader();
			System.out.println("Case1 Header is : " + header);
			Assert.assertEquals(header, AppConstants.CASE1_HEADER);	
		}
		@Test(priority=3,enabled=true)
		public void verifySelectRequeriments(){
			case1.selectHotelCondition();
		}
		@AfterTest
		public void tearDown(){
			driver.quit();
		}
	}