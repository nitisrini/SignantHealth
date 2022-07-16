package com.seleniumdesign.test.StrategyPattern;

import org.testng.annotations.Test;

import com.seleniumdesign.components.common.StrategyPattern.CreditCard;
import com.seleniumdesign.components.common.StrategyPattern.NetBanking;
import com.seleniumdesign.components.common.StrategyPattern.PaymentOptionFactory;
import com.seleniumdesign.components.common.StrategyPattern.PaymentOptionFunctionFactory;
import com.seleniumdesign.components.common.StrategyPattern.PaymentOptions;
import com.seleniumdesign.components.common.StrategyPattern.PaymentScreen;
import com.seleniumdesign.test.BaseTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

public class PaymentTest extends BaseTest {

	private PaymentScreen paymentScreen;

	@BeforeTest
	public void beforeTest() {
		this.paymentScreen = new PaymentScreen(this.driver);
	}

	// Strategy pattern
	@Test(dataProvider = "dp")
	public void paymentTest(PaymentOptions paymentOption, String paymentDetails) {
		this.paymentScreen.setPaymentOption(paymentOption);
		this.paymentScreen.pay(paymentDetails);
	}

	// Combining Factory and Strategy pattern (Supplier)
	@Test(dataProvider = "dp1")
	public void paymentTest1(String paymentOption, String paymentDetails) {
		this.paymentScreen.setPaymentOption(PaymentOptionFactory.getOption(paymentOption));
		this.paymentScreen.pay(paymentDetails);
	}

	// Combining Factory and Strategy pattern (Function)
	@Test(dataProvider = "dp2")
	public void paymentTest2(String paymentOption, String paymentDetails) {
		this.paymentScreen.setPaymentOption(PaymentOptionFunctionFactory.getOption(paymentOption));
		this.paymentScreen.pay(paymentDetails);
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { CreditCard.getInstance(), "Credit Card...Strategy + Singleton" },
				new Object[] { new NetBanking(), "Net Banking...Strategy" }, };
	}

	@DataProvider
	public Object[][] dp1() {
		return new Object[][] { new Object[] { "CC", "Credit Card...Factory + Strategy + Supplier + Singleton" },
				new Object[] { "NB", "Net Banking...Factory + Strategy + Supplier" }, };
	}
	
	@DataProvider
	public Object[][] dp2() {
		return new Object[][] { new Object[] { "CC", "Credit Card...Factory + Strategy + Function + Singleton" },
				new Object[] { "NB", "Net Banking...Factory + Strategy + Function" }, };
	}

}
