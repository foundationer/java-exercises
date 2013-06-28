package com.mulesoft.rovers.exceptions;

public abstract class MarsRoverException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MarsRoverException(final String message) {
		super(message);
	}

	public MarsRoverException() {
		super();
	}
}
