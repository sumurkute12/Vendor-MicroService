package com.cognizant.microservice.exceptions;

public class QuantityLimitExceededException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public QuantityLimitExceededException(String msg) {
		super(msg);
	}

}
