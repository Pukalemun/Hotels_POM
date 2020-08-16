package com.qa.hotels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.util.ElementUtil;

public class Case1 extends BasePage  {
	
WebDriver driver;
ElementUtil elementUtil;
By header = By.xpath("//h1[@class='cont-hd-alt widget-query-heading']");
By Destination = By.xpath("//input[@id='qf-0q-destination']");
By CheckIn = By.cssSelector("#widget-query-label-1");
By SelectedDIn =By.xpath("//*[@id='qf-0q-localised-check-in']");
By SelectedDOut =By.xpath("//*[@id='qf-0q-localised-check-out']");
By CheckOut = By.cssSelector("#widget-query-label-3");
By Adults = By.cssSelector("#qf-0q-room-0-adults");
By Children = By.cssSelector("#qf-0q-room-0-children");
By Search = By.className("cta-strong"); //By Search = By.className("cta cta-strong");
By Child1 = By.xpath("//*[@id='qf-0q-room-0-child-0-age']");
By Child2 =By.xpath("//*[@id='qf-0q-room-0-child-1-age']");

public Case1(WebDriver driver) {
		elementUtil =new ElementUtil(driver);
		this.driver=driver;
		
	}
	public String getTitle() {
		return elementUtil.doGetPageTitle();
	}
	public String getHeader() {
		elementUtil.waitForElementVisible(header);
		return elementUtil.doGetText(header);
	}

public void selectHotelCondition() {
	elementUtil.doClick(Destination);
	elementUtil.doSendKeys(Destination,"Boston, Massachusetts, United States of America");
	
	elementUtil.doClick(CheckIn);
	elementUtil.doClick(SelectedDIn);
	
	elementUtil.doClick(CheckOut);
	elementUtil.doClick(SelectedDOut);
	
	
	//elementUtil.selectValueByText(Rooms,"1");
	elementUtil.selectValueByText(Adults,"2");
	elementUtil.selectValueByText(Children,"2");
	elementUtil.selectValueByText(Child1,"4");
	elementUtil.selectValueByText(Child2,"9");
	
	elementUtil.doClick(Search);
	
	
}
public Case2 goCase2() {
selectHotelCondition();
return new Case2(driver);	
}








}
