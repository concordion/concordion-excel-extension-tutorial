package org.concordion.ext.excel.tutorial;

import java.math.BigDecimal;

public class BasicFareCalculator implements FareCalculator {

	Money flatRate;
	Money costPerMile1;
	BigDecimal costPerMile1UpperLimit;
	Money costPerMile2;
	
	public BasicFareCalculator(Money flatRate,
			Money costPerMile1,
			BigDecimal costPerMile1UpperLimit, 
			Money costPerMile2) {
		this.flatRate = flatRate;
		this.costPerMile1 = costPerMile1;
		this.costPerMile1UpperLimit = costPerMile1UpperLimit;
		this.costPerMile2 = costPerMile2;
	}

	@Override
	public Money calculateFare(BigDecimal distance) {
		BigDecimal distance1 = distance.min(costPerMile1UpperLimit);
		BigDecimal distance2 = distance.subtract(costPerMile1UpperLimit).max(new BigDecimal(0));
		Money mileageCost1 = costPerMile1.multiply(distance1);
		Money mileageCost2 = costPerMile2.multiply(distance2);
		return flatRate.add(mileageCost1).add(mileageCost2);
	}

}
