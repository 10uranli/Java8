package java8;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runners.Parameterized.Parameters;

import com.tutorial.example.lesson1.Account;

class TestClass {

	@Test
	@DisplayName(value = "withdraw")
	void test() {
		Account acn = new Account("ac1", "tr1000", 20000);
		assertFalse(acn.withDraw(-1));
	}
	
	@Test
	@DisplayName(value = "withdraw2")
	void test2() {
		Account acn = new Account("ac1", "tr1000", 20000);
		assertFalse(acn.withDraw(20001));
	}

	@Test
	@DisplayName(value = "withdraw3")
	void test3() {
		Account acn = new Account("ac1", "tr1000", 20000);
		assertTrue(acn.withDraw(20000));
	}
}
