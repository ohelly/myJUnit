package myjunit.calc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

	private static Calculator calculator;
	@Before
	public void setUp() {
		calculator = new Calculator();
	}

	@Test
	public void getSumTwoNumbersCorrectString() {
		assertEquals(3 , calculator.getSumTwoNumbers("1 2"));
		assertEquals(0 , calculator.getSumTwoNumbers(""));
	}

	@Test(expected = NumberFormatException.class)
	public void getSumTwoNumbersUncorrectedString() {
		calculator.getSumTwoNumbers("1 + 2");
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

	@Test(expected = NumberFormatException.class)
	public void getDiffTwoNumbersUncorrectedStrings() {
		calculator.getSumTwoNumbers("1 - 2");
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

	@Test(expected = NumberFormatException.class)
	public void getMultiplicationTwoNumbersUncorrectedStrings() {
		calculator.getSumTwoNumbers("1 * 2");
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

	@Test(expected = NumberFormatException.class)
	public void getDivisionTwoNumbersUncorrectedString() {
		calculator.getDivisionTwoNumbers("16/8");
	}

	@Test(expected = ArithmeticException.class)
	public void getDivisionTwoNumbersDelimitedByZeroWithStrings() {
		calculator.getDivisionTwoNumbers("16 0");
	}

	@Test
	public void testGetDivisionTwoNumbersIntegers() {
		assertEquals(4, calculator.getDivisionTwoNumbers(16, 4));
	}

	@Test(expected = ArithmeticException.class)
	public void getDivisionTwoNumbersIntegersDelimitedByZero(){
		calculator.getDivisionTwoNumbers(16, 0);
	}
}