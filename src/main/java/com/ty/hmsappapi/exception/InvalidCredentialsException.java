package com.ty.hmsappapi.exception;

public class InvalidCredentialsException extends RuntimeException{
	private String message="Invalid Credential";

	public String getMessage() {
		return message;
	}
	public InvalidCredentialsException(String message) {
		super();
		this.message = message;
	}

	public InvalidCredentialsException() {
		super();
	}
}
