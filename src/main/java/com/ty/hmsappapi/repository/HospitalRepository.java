package com.ty.hmsappapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hmsappapi.dto.Hospital;



public interface HospitalRepository extends JpaRepository<Hospital,Integer>{
	
}
