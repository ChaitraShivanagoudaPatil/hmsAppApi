package com.ty.hmsappapi.exception;

public class IdNotFoundException extends RuntimeException{
		private String message="Id does not exist";

		
		public IdNotFoundException() {
		}
		public IdNotFoundException(String message) {
			this.message = message;
		}
		@Override
		public String getMessage() {
			return message;
		}
		

	}

