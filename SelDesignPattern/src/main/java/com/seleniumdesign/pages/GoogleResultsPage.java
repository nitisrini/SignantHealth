package com.seleniumdesign.pages;

import org.openqa.selenium.WebDriver;

import com.seleniumdesign.components.results.NavigationBar;
import com.seleniumdesign.components.results.ResultStatus;

public class GoogleResultsPage {
	
	private NavigationBar navigationBar;
	private ResultStatus resultStatus;
	
	public GoogleResultsPage(final WebDriver driver) {
		navigationBar = new NavigationBar(driver);
		resultStatus = new ResultStatus(driver);
	}
	
	public NavigationBar getNavigationBar() {
		return navigationBar;
	}
	
	public ResultStatus getResultStatus() {
		return resultStatus;
	}
	
}
