package com.seleniumdesign.components.common;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {
	
	protected WebDriverWait wait;

	public abstract boolean isDisplayed();
	
	public AbstractComponent(final WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
	
}
