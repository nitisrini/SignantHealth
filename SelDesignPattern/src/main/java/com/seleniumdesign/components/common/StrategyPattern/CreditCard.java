package com.seleniumdesign.components.common.StrategyPattern;

public class CreditCard implements PaymentOptions {

//	private locators for credit card fields

	// Singleton starts
	// Private const to avoid inst reation of this class
	private CreditCard() {};

	private static class Singleton {
		public static final CreditCard instance = new CreditCard();
	}
	
	public static CreditCard getInstance() {
		return Singleton.instance;
	}
	// Singleton ends

	@Override
	public void enterPaymentInformation(String paymentDetails) {
		// action on locators
		// entering cc details
		System.out.println("Inside credit card-" + paymentDetails);
	}

}
