package myJUnit.calc;

public class Calculator {

	/*
	Нужен для проверки assertTrue
	 */
	public boolean checkedString(String str) {
		if (str != null)
			return true;
		return false;
	}

	public int getSumTwoNumbers(String str) throws NumberFormatException {
		if (checkedString(str)) {
			str = str.trim();
			if (str.length() != 0) {
				return Integer.parseInt(str.split(" ")[0])
						+ Integer.parseInt(str.split(" ")[1]);
			}
		}
		return 0;
	}

	public int getSumTwoNumbers(int first, int second) {
		return first + second;
	}

	public int getDiffTwoNumbers(int first, int second) {
		return first - second;
	}

	public int getDiffTwoNumbers(String str) throws NumberFormatException {
		if (str != null) {
			str = str.trim();
			if (str.length() != 0) {
				return Integer.parseInt(str.split(" ")[0])
						- Integer.parseInt(str.split(" ")[1]);
			}
		}
		return 0;
	}

	public int getMultiplicationTwoNumbers(int first, int second) {
		return first * second;
	}

	public int getMultiplicationTwoNumbers(String str) throws NumberFormatException{
		if (str != null) {
			str = str.trim();
			if (str.length() != 0) {
				return Integer.parseInt(str.split(" ")[0])
						* Integer.parseInt(str.split(" ")[1]);
			}
		}
		return 0;
	}

	public int getDivisionTwoNumbers(int first, int second) throws ArithmeticException {
		return first / second;
	}

	public int getDivisionTwoNumbers(String str) throws NumberFormatException, ArithmeticException {
		if (str != null) {
			str = str.trim();
			if (str.length() != 0) {
				return Integer.parseInt(str.split(" ")[0])
						/ Integer.parseInt(str.split(" ")[1]);
			}
		}
		return 0;
	}
}
