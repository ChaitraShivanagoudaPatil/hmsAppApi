package com.ty.hmsappapi.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date=new Date(System.currentTimeMillis());
	private String status;
	private String cause;
	private String priority;
	@OneToMany
	List<MedOrder> medOrders;
	@ManyToOne
	private Person person;
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Branch branch;

}
