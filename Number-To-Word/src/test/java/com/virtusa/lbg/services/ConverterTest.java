package com.virtusa.lbg.services;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.virtusa.lbg.exception.InvalidDataException;

public class ConverterTest {

	private static WordConverterImpl converter;
	
	@BeforeClass
	public static void setUp() {
		converter = new WordConverterImpl();
	}

	@Test
	public void validScenariosTest() throws InvalidDataException {
		assertEquals("zero", converter.convertNumberToWord(0));
		assertEquals("one", converter.convertNumberToWord(1));
		assertEquals("fifteen", converter.convertNumberToWord(15));
		assertEquals("thirty one", converter.convertNumberToWord(31));
		assertEquals("one hundred and one", converter.convertNumberToWord(101));
		assertEquals("nine hundred and ninety nine", converter.convertNumberToWord(999));
		assertEquals(
				"nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine",
				converter.convertNumberToWord(999999999));

	}

	@Test
	public void formUnitsTensWordValidTest() throws InvalidDataException {

		assertEquals("fifteen", converter.formUnitsTensDigitsWord(15).trim());
		assertEquals("ninety nine", converter.formUnitsTensDigitsWord(99).trim());
		assertEquals("fifty six", converter.formUnitsTensDigitsWord(56).trim());
		assertEquals("thirty three", converter.formUnitsTensDigitsWord(33).trim());

	}

	@Test(expected = InvalidDataException.class)
	public void unitsTensTestInsteadThreeDigitGiven() throws InvalidDataException {

		assertEquals("five hundred", converter.formUnitsTensDigitsWord(500).trim());
	}

	@Test
	public void hundredthPlaceWordTest() throws InvalidDataException {

		assertEquals("five hundred", converter.formHundredthPlaceWord(515).trim());
		assertEquals("eight hundred", converter.formHundredthPlaceWord(899).trim());
		assertEquals("three hundred", converter.formHundredthPlaceWord(300).trim());
		assertEquals("one hundred", converter.formHundredthPlaceWord(100).trim());

	}
	
	@Test(expected = InvalidDataException.class)
	public void hundredthPlaceWordTestWithFourGigit() throws InvalidDataException {

		assertEquals("five hundred", converter.formThreeDigitEquiWord(5154, 0,new StringBuilder()).trim());
	
	}

	@Test
	public void threeDigitsWordTest() throws InvalidDataException {
		StringBuilder sb = new StringBuilder();
		assertEquals("five hundred and fifteen million", converter.formThreeDigitEquiWord(515, 0,sb).trim());
		assertEquals("three hundred thousand", converter.formThreeDigitEquiWord(300, 1,sb).trim());
		assertEquals("three hundred", converter.formThreeDigitEquiWord(300, 3,sb).trim());

	}
	
	@Test
	public void threeDigitsWordTest2() throws InvalidDataException {
		StringBuilder sb = new StringBuilder();
		sb.append("five million");
		assertEquals("three hundred and one thousand", converter.formThreeDigitEquiWord(301, 1,sb).trim());
		assertEquals("three hundred and one", converter.formThreeDigitEquiWord(301, 3,sb).trim());

	}
}
