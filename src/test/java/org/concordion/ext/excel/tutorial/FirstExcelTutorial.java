package org.concordion.ext.excel.tutorial;

import java.math.BigDecimal;

import org.concordion.api.extension.Extensions;
import org.concordion.ext.excel.ExcelExtension;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
@Extensions(ExcelExtension.class)
public class FirstExcelTutorial {

	private FareCalculator fc;

	public void setupCalculator(String flatRate, String cpm1, String cpm1Upper, String cpm2) {
		
		fc = new BasicFareCalculator(new Money(flatRate), 
				new Money(cpm1),
				new BigDecimal(cpm1Upper),
				new Money(cpm2));
	}

	
	public String calculateFare(String distance) {
		Money result = fc.calculateFare(new BigDecimal(distance));
		
		return result.toString();
	}
}

