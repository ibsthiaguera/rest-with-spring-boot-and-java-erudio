package br.com.cadamuro;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

//@Order(3)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MethodOrderedByOrderIndexTest {
	
	StringBuilder actualValue = new StringBuilder();
	
	@AfterEach
	void afterEach() {
		System.out.println("The actual value is: " + actualValue);
	}

	@Test
	@Order(3)
	void testB() {
		System.out.println("Running Test B");
		actualValue.append("3");
	}

	@Test
	@Order(1)
	void testD() {
		System.out.println("Running Test D");
		actualValue.append("1");
	}

	@Test
	@Order(4)
	void testA() {
		System.out.println("Running Test A");
		actualValue.append("4");
	}

	@Test
	@Order(2)
	void testC() {
		System.out.println("Running Test C");
		actualValue.append("2");
	}

}
