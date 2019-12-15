package com.virtusa.lbg.validation;

import com.virtusa.lbg.exception.InvalidDataException;

public class UserInputImpl implements UserInput{
	
	public int validateInput(String inputData) throws InvalidDataException{
		int validNumber;
		try{
			validNumber = Integer.parseInt(inputData);
		}
		catch (NumberFormatException e) {
			throw new InvalidDataException(" Enter an integer value");
		}
		if(validNumber < 0 || validNumber > 999999999){
			throw new RuntimeException("Number must be in the range  [0, 999999999] ");
		}
		return validNumber;
	}

}
