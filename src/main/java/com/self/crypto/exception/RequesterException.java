package com.self.crypto.exception;

public class RequesterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RequesterException(String message) {
		super(message);
	}

	public RequesterException(String message, Throwable e) {
		super(message, e);
	}

}
