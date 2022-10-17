package com.ty.hmsappapi.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Entity
@Data
public class BranchManager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@NotNull
	private long phone;
	private String password;
	private String email;
	@NotNull
	private String address;
	
}
