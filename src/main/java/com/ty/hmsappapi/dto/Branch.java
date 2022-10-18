package com.ty.hmsappapi.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Data
public class Branch {
	@Id	
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String address;
	private String city;
	private long phone;
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	Hospital hospital;
    @OneToMany
	List<Encounter> encounter;

}
