package com.seleniumdesign.components.common.StrategyPattern;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class PaymentOptionFunctionFactory {

	// Singleton
	private static final Function<String, PaymentOptions> CC = t -> CreditCard.getInstance();
	
	// Non Singleton
//	private static final Function<String, PaymentOptions> CC = t -> new CreditCard();
	private static final Function<String, PaymentOptions> NB = t -> new NetBanking();

	private static final Map<String, Function<String, PaymentOptions>> optionsMap = new HashMap<>();

	static {
		optionsMap.put("CC", CC);
		optionsMap.put("NB", NB);
	}

	public static PaymentOptions getOption(String option) {
		return optionsMap.get(option).apply(option);
	}

}
