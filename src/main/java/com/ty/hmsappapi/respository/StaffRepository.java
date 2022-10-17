package com.ty.hmsappapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hmsappapi.dto.Staff;


public interface StaffRepository extends JpaRepository<Staff, Integer> {
	public Staff findByEmailAndPassword(String email, String passowrd);

}
