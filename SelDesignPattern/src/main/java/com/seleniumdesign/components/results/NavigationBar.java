package com.seleniumdesign.components.results;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.seleniumdesign.components.common.AbstractComponent;

public class NavigationBar extends AbstractComponent{
	
	@FindBy(id = "hdtb")
	private WebElement navigationBar;
	
	@FindBy(linkText = "News")
	private WebElement news;

	public NavigationBar(WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isDisplayed() {
		return this.wait.until(driver -> this.navigationBar.isDisplayed());
	}
	
	public void gotoNewsTab() {
		this.news.click();
	}

}
