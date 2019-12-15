package com.virtusa.lbg.services;

import com.virtusa.lbg.exception.InvalidDataException;

public interface WordConverter {
	
	String convertNumberToWord(int number) throws InvalidDataException;

}
