package com.seleniumdesign.components.common.StrategyPattern;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentOptionFactory {

	// Singleton
	private static final Supplier<PaymentOptions> CC = () -> CreditCard.getInstance();

	// Non Singleton
//	private static final Supplier<PaymentOptions> CC = () -> new CreditCard();
	private static final Supplier<PaymentOptions> NB = () -> new NetBanking();

	private static final Map<String, Supplier<PaymentOptions>> optionsMap = new HashMap<String, Supplier<PaymentOptions>>();

	static {
		optionsMap.put("CC", CC);
		optionsMap.put("NB", NB);
	}

	public static PaymentOptions getOption(String option) {
		return optionsMap.get(option).get();
	}

}
