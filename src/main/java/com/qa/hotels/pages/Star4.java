package com.qa.hotels.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.hotels.base.BasePage;
import com.qa.hotels.util.ElementUtil;
import com.qa.hotels.util.JavaScriptUtil;

	public class Star4  extends BasePage{
		
		WebDriver driver;
		ElementUtil elementUtil;
		JavaScriptUtil javaScriptUtil;

		 public Star4(WebDriver driver) {
			
			this.driver = driver;
			elementUtil = new ElementUtil(driver);
		}	
		     // locators
            By threeStars = By.xpath("//input[@id='f-star-rating-3']");
		    By fourStars=By.xpath("//input[@id='f-star-rating-4']"); //   By fourStars=By.id("f-star-rating-4");
	    	By fiveStars = By.xpath("//input[@id='f-star-rating-5']");
			By distance=By.xpath("//a[@data-menu='sort-submenu-distance']");
			By city=By.xpath("//a[text()='City center']");

		public boolean IsFourStarsInTenMiles() throws InterruptedException {
				
			
				elementUtil.waitForElementPresent(fourStars);
				  elementUtil.doClick(fourStars);
				  
				  javaScriptUtil.scrollDownWithIterator(driver);
				  Thread.sleep(5000);
				  
				  elementUtil.waitForElementVisible(distance);
				  elementUtil.doClick(distance);
				  
				  elementUtil.waitForElementPresent(city);
				  elementUtil.doClick(city);
				  
			
			    List<WebElement> hList = driver.findElements(By.cssSelector("a[class='property-name-link']"));
				List<WebElement> distanceList = driver.findElements(By.cssSelector("ul[class='property-landmarks']"));

	
				for (int i = 0; i < distanceList.size(); i++) {
					String distances = distanceList.get(i).getText();
					String dist = distances.split(" ")[0].trim();
					double dist1 = Double.parseDouble(dist);
					if (dist1 < 10) {
						for (int j = 0; j < hList.size(); j++) {
							String hotelNames = hList.get(j).getText();	 
							System.out.println(hotelNames);
					}
						
				}
					return true;
			}
			return false;
			}

	  public Star5 goStar5() {
				 return new Star5(driver);
				 }
			
}
