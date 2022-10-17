package com.ty.hmsappapi.exception;


import lombok.Data;

@Data
public class IdnotFoundException extends RuntimeException{
	String message ="Given ID is not exist";

	public IdnotFoundException(String message) {
		this.message = message;
	}

	public IdnotFoundException() {
	}
		
}

