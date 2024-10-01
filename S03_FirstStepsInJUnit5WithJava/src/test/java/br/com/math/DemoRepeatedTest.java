package br.com.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

class DemoRepeatedTest {

	SimpleMath math;

	@BeforeEach
	void beforeEachMethod() {
		System.out.println("Running @BeforeEach method");
		math = new SimpleMath();
	}

	@RepeatedTest(value = 3, name = "{displayName}. Repetition {currentRepetition} of {totalRepetitions} !")
	@DisplayName("Test Division by Zero")
	void testDivision_WhenFirstNumberIsDividedByZero_ShouldThrowArithmeticException(RepetitionInfo repetitionInfo, TestInfo testInfo) {

		System.out.println("Test Division by Zero " + repetitionInfo.getCurrentRepetition() + " of "
				+ repetitionInfo.getTotalRepetitions());
		
		System.out.println("Running " + testInfo.getTestMethod().get().getName());

		// Given
		double firstNumber = 6.2D;
		double secondNumber = 0D;

		var expectedMessage = "Impossible to divide by zero!";

		ArithmeticException actual = assertThrows(ArithmeticException.class, () -> {
			// When & Then
			math.division(firstNumber, secondNumber);
		}, () -> "Division by zero should throw an Arithmetic Exception");

		assertEquals(expectedMessage, actual.getMessage(), () -> "Unexpected exception message!");
	}

}
