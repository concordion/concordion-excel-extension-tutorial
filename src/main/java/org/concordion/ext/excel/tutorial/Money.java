package org.concordion.ext.excel.tutorial;

import java.math.BigDecimal;

public class Money {
	
	private BigDecimal amount;
	
	public Money(String currencyAmount) {
		this.amount = new BigDecimal(currencyAmount.replace("£", ""));
	}

	private Money(BigDecimal amount) {
		this.amount = amount;
	}

	public Money multiply(BigDecimal distance1) {
		return new Money(amount.multiply(distance1));
	}

	public Money add(Money dosh) {
		return new Money(amount.add(dosh.amount));
	}

	public String toString() {
		return "£" + amount.toString();
	}
}
