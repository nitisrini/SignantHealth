package com.seleniumdesign.components.results;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.seleniumdesign.components.common.AbstractComponent;

public class ResultStatus extends AbstractComponent{
	
	@FindBy(id="result-stats")
	private WebElement result;

	public ResultStatus(WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isDisplayed() {
		return this.wait.until(driver -> this.result.isDisplayed());
	}
	
	public String getResult() {
		return this.result.getText();
	}

}
