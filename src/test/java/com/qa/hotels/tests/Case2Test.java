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
import com.qa.hotels.util.AppConstants;

public class Case2Test {
WebDriver driver;
BasePage basePage;
Properties prop;
Case1 case1;
Case2 case2;

	
@BeforeTest
public void setUp() throws InterruptedException {

	basePage=new BasePage();
	prop=basePage.init_properties();
	String browserName=prop.getProperty("browser");
	driver=basePage.init_driver(browserName);
	driver.get(prop.getProperty("url"));
	case1=new Case1(driver);
	case2=case1.goCase2();
	Thread.sleep(5000);
}
	
	@Test (priority=1,enabled=true)
	public void verifyIsHiltonThree() throws InterruptedException {
	System.out.println(case2.IsHiltonThree());
	
	}
	@Test(priority=2,enabled=true)
	public void verifyGetPPageTitle() {
		String title=case2.getPageTitle();
		Assert.assertEquals(title,AppConstants.CASE2_TITLE);
	}
	@Test(priority=3,enabled=true)
	public void verifyGetPageHeader(){
		String header=case2.getPageHeader();
		System.out.println("Case2 Header is : " +header);
		Assert.assertEquals(header, AppConstants.CASE2_HEADER);	
	}
	@AfterTest
	public void tearDown() {
	driver.quit();	
	}
}