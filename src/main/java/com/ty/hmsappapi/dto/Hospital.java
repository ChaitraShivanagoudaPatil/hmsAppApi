package com.ty.hmsappapi.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Hospital {
	@Id	
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String name;
	private String website;
	@OneToMany(mappedBy = "hospital",cascade = CascadeType.ALL)
	List<Branch> branch;
	

}
