package com.ty.hmsappapi.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String date;
	private String cause;
	private String priority;
	@OneToMany(mappedBy = "encounter")
	List<MedOrder> medOrders;
	@ManyToOne
	private Person person;

}
