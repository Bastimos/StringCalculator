package com.sebastianwizert.stringcalc;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Sebastian Wizert
 * sebastianwizert@gmail.com
 */

public class StringCalcuatorTests {

	/**
	 * Empty String Test
	 * Should return zero
	 */
	@Test
	public void emptyStringTest() {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals ( 0, stringCalculator.add("") );
	}

	/**
	 * Correct Input Test
	 * All should return 6
	 */
	@Test
	public void correctInput() {

		StringCalculator stringCalculator = new StringCalculator();
		assertEquals ( 6, stringCalculator.add("1\n2,3") );
		assertEquals ( 6, stringCalculator.add("1,2,3") );
		assertEquals ( 6, stringCalculator.add("1,2\n3") );
	}
	

	/**
	 * Incorrect Input Test
	 * Should throw Exception
	 */
	@Test
	public void incorrectInput() {

		StringCalculator stringCalculator = new StringCalculator();
		try {
			stringCalculator.add("1,\n2");
		} catch(Exception e) {
			e.printStackTrace();
			assertNotNull(e);
		}
	}
	
	/**
	 * Custom Delimiters Test
	 * Should return 6
	 */
	@Test
	public void customDelimiters() {
		
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals ( 6, stringCalculator.add("//.\n1.2.3") );
		assertEquals ( 6, stringCalculator.add("//***\n1***2***3") );
	}
}
