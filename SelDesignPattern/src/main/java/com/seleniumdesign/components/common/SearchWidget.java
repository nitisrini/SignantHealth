package com.seleniumdesign.components.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchWidget extends AbstractComponent{

	public SearchWidget(WebDriver driver) {
		super(driver);
	}

	@FindBy(name="q")
	private WebElement searchBox;
	
	public void enter(String keyword) {
		this.searchBox.clear();
		this.searchBox.sendKeys(keyword);
	}
	
	@Override
	public boolean isDisplayed() {
		return this.wait.until(driver -> this.searchBox.isDisplayed());
	}

}
