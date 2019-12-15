package com.virtusa.lbg;

import java.util.Scanner;

import com.virtusa.lbg.exception.InvalidDataException;
import com.virtusa.lbg.services.WordConverter;
import com.virtusa.lbg.services.WordConverterImpl;
import com.virtusa.lbg.validation.UserInput;
import com.virtusa.lbg.validation.UserInputImpl;

public class App {

	public static void main(String[] args) throws InvalidDataException {

		final WordConverter converter = new WordConverterImpl();
		final UserInput input = new UserInputImpl();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number to get equivalent english word : ");

		while (scanner.hasNext()) {
			
			String data = scanner.nextLine();
			// validate input
			int number = input.validateInput(data);

			// convert number to word
			String word = converter.convertNumberToWord(number);
			System.out.println(number + " = " + word);
		}
		scanner.close();
	}
}
