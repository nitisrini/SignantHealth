package com.seleniumdesign.components.common.StrategyPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PaymentScreen {
	
	private WebDriver driver;
	// Object reference of all Payment screen component classes
	private PaymentOptions paymentOption;
	
	public PaymentScreen(WebDriver driver) {
		this.driver = driver;
	}
	
	// Strategy pattern
	public void setPaymentOption(PaymentOptions paymentOption) {
		this.paymentOption = paymentOption;
		PageFactory.initElements(driver, this.paymentOption);
	}
	
	public void pay(String details) {
		this.paymentOption.enterPaymentInformation(details);
	}

}
