package com.virtusa.lbg.validation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.virtusa.lbg.exception.InvalidDataException;

public class UserInputTest {

	UserInputImpl userInput;

	@Before
	public void setUp() {
		userInput = new UserInputImpl();
	}

	@Test
	public void validIntegerTest() throws Exception {
		assertEquals(54546, userInput.validateInput("54546"));
	}
	
	@Test
	public void zeroScenarioTest() throws Exception {
		assertEquals(0, userInput.validateInput("0"));
	}

	@Test(expected = InvalidDataException.class)
	public void stringInputTest() throws Exception {
		userInput.validateInput("string");
	}

	@Test(expected = InvalidDataException.class)
	public void specialKeysTest() throws Exception {
		userInput.validateInput("@%$$&*");
	}

	@Test(expected = RuntimeException.class)
	public void negativeValueTest() throws Exception {
		userInput.validateInput("-546");
	}

	@Test(expected = RuntimeException.class)
	public void outOfRangeTest() throws Exception {
		userInput.validateInput("1245963698");
	}
}
