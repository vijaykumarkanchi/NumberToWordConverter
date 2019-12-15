package com.virtusa.lbg.exception;
/**
  * customized exception class to handle invalid data.
 */

public class InvalidDataException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public InvalidDataException(String message){
		super(message);
	}
}
