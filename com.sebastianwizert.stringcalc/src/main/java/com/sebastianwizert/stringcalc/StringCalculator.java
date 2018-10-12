package com.sebastianwizert.stringcalc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sebastian Wizert
 * sebastianwizert@gmail.com
 */

public class StringCalculator {
	
	private String customDelimiter;

	public int add(String numbers) {

		if( numbers.isEmpty() ) {
			return 0;
		} else {
			if( numbers.startsWith("//" )  ) { 
				getCustomDelimiter(numbers );
				numbers = numbers.substring(2+customDelimiter.length() );
			}
			return validate(numbers);
		} 
	}

	private boolean getCustomDelimiter(String numbers) {
		if(numbers.startsWith("//")) {
			customDelimiter = numbers.substring(2, numbers.indexOf("\n"));
		}
		return false;
	}

	private int validate(String numbers) {
		String[] stringNumbersArray = null;
		if(customDelimiter == null) {
			stringNumbersArray = numbers.split("[,\n]");
		} else {
			stringNumbersArray = numbers.split("[,|"+customDelimiter+"\n]");
		}
		List <Integer> integersList = new ArrayList<Integer>();
		for(String stringNumber : stringNumbersArray) {
			if(stringNumber.equals("") ) continue;
			integersList.add( Integer.parseInt(stringNumber));
		}
		return sumIntegers(integersList);
	}

	private int sumIntegers(List<Integer> integersList) {
		int sum = 0;
		for(int number : integersList) {
			if(number > 1000) continue;
			sum += number;
		}
		return sum;
	}
}
