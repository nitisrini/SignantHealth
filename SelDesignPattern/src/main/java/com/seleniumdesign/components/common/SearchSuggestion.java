package com.seleniumdesign.components.common;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchSuggestion extends AbstractComponent{
	
	@FindBy(css = "li.sbct")
	private List<WebElement> suggestions;

	public SearchSuggestion(WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isDisplayed() {
		return this.wait.until(driver -> this.suggestions.size() > 5);
	}
	
	public void chooseSuggestionByIndex(int index) {
		this.suggestions.get(index).click();
	}

}
