package com.seleniumdesign.pages;

import org.openqa.selenium.WebDriver;

import com.seleniumdesign.components.common.SearchSuggestion;
import com.seleniumdesign.components.common.SearchWidget;

public class GoogleMainPage {
	
	private WebDriver driver;
	private SearchWidget searchWidget;
	private SearchSuggestion searchSuggestion;
	
	public GoogleMainPage(final WebDriver driver) {
		this.driver = driver;
		searchWidget = new SearchWidget(driver);
		searchSuggestion = new SearchSuggestion(driver);
	}
	
	public void goToPage(String url) {
		driver.get(url);
	}
	
	public SearchWidget getSearchWidget() {
		return searchWidget;
	}
	
	public SearchSuggestion getSearchSuggestion() {
		return searchSuggestion;
	}

}
