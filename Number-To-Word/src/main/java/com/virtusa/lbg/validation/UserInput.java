package com.virtusa.lbg.validation;

import com.virtusa.lbg.exception.InvalidDataException;

public interface UserInput {
	
	int validateInput(String inputData) throws InvalidDataException;

}
