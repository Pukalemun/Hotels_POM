package com.qa.hotels.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.util.ElementUtil;
import com.qa.hotels.util.JavaScriptUtil;

public class Case2 extends BasePage  {
	
WebDriver driver;
ElementUtil elementUtil;
JavaScriptUtil javaScriptUtil;

By threeStars = By.xpath("//*[@id='f-star-rating-3']");
By header =By.xpath("//h1[text()='Boston, Massachusetts, United States of America']");

public Case2(WebDriver driver) {
	this.driver=driver;
	elementUtil =new ElementUtil(driver);
}
public String getPageTitle() {
	return elementUtil.doGetPageTitle();
}
public String getPageHeader() {
	return elementUtil.doGetText(header);
}
public boolean IsHiltonThree() throws InterruptedException {
	elementUtil.waitForElementVisible(threeStars);
	elementUtil.doClick(threeStars);
	
	JavaScriptUtil.scrollDownWithIterator(driver);
	
	List<WebElement> hotels	 = driver.findElements(By.cssSelector("a[class='property-name-link']"));
	System.out.println(hotels.size());
	
	Thread.sleep(50000);
	for (int i = 0; i < hotels.size(); i++) {
		String hotelNames = hotels.get(i).getText();
	
		if (hotelNames.contains("Hilton")) {
			System.out.println(hotelNames);
			return true;
          }
		}return false;
	}
public Star4 goStar4() {
return new Star4(driver);
}
}