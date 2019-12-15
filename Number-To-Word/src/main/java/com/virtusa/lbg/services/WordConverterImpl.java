package com.virtusa.lbg.services;

import com.virtusa.lbg.exception.InvalidDataException;
import com.virtusa.lbg.util.ConverterHelper;

public class WordConverterImpl implements WordConverter {

		public static final int  millionsPlace = 1000000;
		public static final int  thousandsPlace = 1000;
		public static final int  hundredsPlace = 100;
		public static final int  unitsPlace = 19;
		public static final int  tensPlace = 10;

		public String convertNumberToWord(int number) throws InvalidDataException {
			StringBuilder englishWord = new StringBuilder();

			if (number == 0) {
				englishWord.append("zero");

			} else {
				// first three digits equivalent
				englishWord.append(formThreeDigitEquiWord(number / millionsPlace, 0, englishWord));

				// next three digits equivalent
				englishWord.append(formThreeDigitEquiWord((number % millionsPlace) / thousandsPlace, 1, englishWord));

				// last three digits equivalent
				englishWord.append(formThreeDigitEquiWord((number % thousandsPlace) % thousandsPlace, 3, englishWord));
			}
			return englishWord.toString().trim();
		}

		public String formThreeDigitEquiWord(int num, int place, StringBuilder englishWord) throws InvalidDataException {
			StringBuilder threeDigitEquiWord = new StringBuilder();
			String hundredthPlaceWord;

			try {
				hundredthPlaceWord = formHundredthPlaceWord(num);
				if (hundredthPlaceWord.length() > 0) {
					threeDigitEquiWord.append(hundredthPlaceWord);
					threeDigitEquiWord.append(ConverterHelper.appendAND(num % hundredsPlace, englishWord, threeDigitEquiWord));
				}
				threeDigitEquiWord.append(formUnitsTensDigitsWord(num % hundredsPlace));
				if (threeDigitEquiWord.length() > 0) {

					threeDigitEquiWord.append(ConverterHelper.higherPlace[place]);
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				throw new InvalidDataException("Input should be less than 1000");
			}
			return threeDigitEquiWord.toString();
		}

		public String formHundredthPlaceWord(int n) {
			StringBuilder threeDigitWord = new StringBuilder();

			int x = n / hundredsPlace;
			if (n > unitsPlace) {
				threeDigitWord.append(ConverterHelper.units[x]);
			}
			if (x > 0) {
				threeDigitWord.append(ConverterHelper.higherPlace[2]);
			}

			return threeDigitWord.toString();

		}

		public String formUnitsTensDigitsWord(int n) throws InvalidDataException {
			StringBuilder lastTwoDigitsWords = new StringBuilder();
			try {
				if (n > unitsPlace) {
					lastTwoDigitsWords.append(ConverterHelper.tens[n / tensPlace] + ConverterHelper.units[(n % tensPlace)]);
				} else {
					lastTwoDigitsWords.append(ConverterHelper.units[n]);
				}

			} catch (ArrayIndexOutOfBoundsException e) {
				throw new InvalidDataException("Input should be less than 100");
			}
			return lastTwoDigitsWords.toString();
		}
}
