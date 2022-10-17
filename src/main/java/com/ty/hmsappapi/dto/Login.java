package com.ty.hmsappapi.dto;

<<<<<<< HEAD
import lombok.Data;

@Data
public class Login {
	private String email;
	private String password;
	
=======
public class Login {
	private String email;
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
>>>>>>> debf1168d5ecb33f6635b84d5afbb1cedf272602
}
