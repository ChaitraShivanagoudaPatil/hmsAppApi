package com.ty.hmsappapi.exception;


import lombok.Data;

@Data
public class InvalidCredentialsException extends RuntimeException{
	String message = "Given credentials are invalid";

	public InvalidCredentialsException(String message) {

		this.message = message;
	}

	public InvalidCredentialsException() {
		super();
	}
}
		



