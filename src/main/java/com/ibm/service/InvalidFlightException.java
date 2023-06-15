package com.ibm.service;

public class InvalidFlightException extends Exception{
	
	public InvalidFlightException() {
		super();
	}
	
	public InvalidFlightException(String message)
	{
		super(message);
	}

}
