package com.ty.hmsappapi.util;

<<<<<<< HEAD
import lombok.Data;

@Data
=======
>>>>>>> debf1168d5ecb33f6635b84d5afbb1cedf272602
public class ResponseStructure<T> {
	private int status;
	private String message;
	private T data;

<<<<<<< HEAD
=======
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
>>>>>>> debf1168d5ecb33f6635b84d5afbb1cedf272602
}
