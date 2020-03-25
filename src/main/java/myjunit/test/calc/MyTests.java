package myjunit.test.calc;

import myjunit.annotation.After;
import myjunit.annotation.Before;
import myjunit.annotation.Test;
import myjunit.calc.Calculator;

import static myjunit.asserts.MyJUnitAsserts.*;

public class MyTests {
	private static Calculator calculator;

	@Before
	public void setUp() {
		System.out.println("Checked annotation before");
		calculator = new Calculator();
	}

	@Test
	public void checkAssertNotNullNotNull() {
		assertNotNull(calculator);
	}

	@Test
	public void checkAssertNotNullNull() {
		assertNotNull(null);
	}

	@Test
	public void checkAssertTrueTrue() {
		assertTrue(calculator.checkedString("assertTrue"));
	}

	@Test
	public void checkAssertTrueFalse() {
		assertTrue(calculator.checkedString(null));
	}

	@Test
	public void getSumTwoNumbersCorrectString() {
		assertEquals(3 , calculator.getSumTwoNumbers("1 2"));
		assertEquals(0 , calculator.getSumTwoNumbers(""));
	}


	@Test
	public void testGetSumTwoNumbersIntegers() {
		assertEquals(3, calculator.getSumTwoNumbers(1, 2));
	}

	@Test
	public void getDiffTwoNumbersCorrectStrings() {
		assertEquals(3, calculator.getDiffTwoNumbers("5 2"));
		assertEquals(0, calculator.getDiffTwoNumbers(""));
	}

	@Test
	public void testGetDiffTwoNumbersIntegers() {
		assertEquals(3, calculator.getDiffTwoNumbers(5, 2));
	}

	@Test
	public void getMultiplicationTwoNumbersCorrectStrings() {
		assertEquals(16, calculator.getMultiplicationTwoNumbers("2 8"));
		assertEquals(0, calculator.getMultiplicationTwoNumbers(""));
	}

	@Test
	public void testGetMultiplicationTwoNumbersIntegers() {
		assertEquals(16, calculator.getMultiplicationTwoNumbers(4, 4));
	}

	@Test
	public void getDivisionTwoNumbersCorrectString() {
		assertEquals(2, calculator.getDivisionTwoNumbers("16 8"));
		assertEquals(0, calculator.getDivisionTwoNumbers(""));
	}

	@Test
	public void testGetDivisionTwoNumbersIntegers() {
		assertEquals(4, calculator.getDivisionTwoNumbers(16, 4));
	}

	@After
	public void setDown() {
		System.out.println("Checked annotation after\n");
	}
}
