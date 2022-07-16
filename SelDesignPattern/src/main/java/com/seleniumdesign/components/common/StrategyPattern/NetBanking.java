package com.seleniumdesign.components.common.StrategyPattern;

public class NetBanking implements PaymentOptions{

	// private locators for net banking fields
	
	@Override
	public void enterPaymentInformation(String paymentDetails) {
		// action on locators
		// entering net banking details
		System.out.println("Inside Net banking-" + paymentDetails);
	}
	
}
