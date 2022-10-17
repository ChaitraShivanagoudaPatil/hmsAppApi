package com.ty.hmsappapi.exception;

<<<<<<< HEAD
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
		
=======
public class InvalidCredentialsException extends RuntimeException {
	private String message = "Invalid credentials";

	public InvalidCredentialsException() {
	}

	public InvalidCredentialsException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
>>>>>>> debf1168d5ecb33f6635b84d5afbb1cedf272602
