package com.ty.hmsappapi.exception;

public class IdnotFoundException extends RuntimeException{
		private String message="Id does not exist";

		
		public IdnotFoundException() {
		}
		public IdnotFoundException(String message) {
			this.message = message;
		}
		@Override
		public String getMessage() {
			return message;
		}
		

	}

