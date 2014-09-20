package org.concordion.ext.excel.tutorial;

import org.concordion.api.extension.Extensions;
import org.concordion.ext.excel.ExcelExtension;
import org.concordion.ext.excel.tutorial.BasicFareCalculator;
import org.concordion.ext.excel.tutorial.FareCalculator;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
@Extensions(ExcelExtension.class)
public class FirstExcelTutorial {

	

	public void setupCalculator(String flatRate, String cpm1, String cpm1Upper, String cpm2) {
		
		fc = new BasicFareCalculator(Double.parseDouble(flatRate), 
				Double.parseDouble(cpm1),
				Double.parseDouble(cpm1Upper),
				Double.parseDouble(cpm2));
	}
	
	private FareCalculator fc;
	
	public String calculateFare(String distance) {
		double result = fc.calculateFare(Double.parseDouble(distance));
		
		return ((Double)result).toString();
	}
	
}
