package myjunit.asserts;

public class MyJUnitAsserts {
	public static void assertEquals(Object first, Object second) {
		if (!first.equals(second))
			System.out.println("Test failed:\n\tfirst object not equals second object:" +
					"\n\tExpected: " + first + "\n\tResult: " + second);
		else
			System.out.println("Test passed:\n\tExpected: " + first + "\n\tResult: " + second);
	}

	public static void assertTrue(Object obj) {
		if (!obj.equals(true))
			System.out.println("Test failed:\n\tExpected: true\n\tResult: false");
		else
			System.out.println("Test passed:\n\tExpected: true\n\tResult: true");
	}

	public static void assertNotNull(Object obj) {
		if (obj == null)
			System.out.println("Test failed:\n\tExpected Not Null");
		else
			System.out.println("Test passed:\n\tObject Not Null");
	}
}
