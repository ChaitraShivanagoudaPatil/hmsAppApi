package com.ty.hmsappapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hmsappapi.dto.Staff;
<<<<<<< HEAD
import com.ty.hmsappapi.repository.StaffRepository;
=======
import com.ty.hmsappapi.respository.StaffRepository;
>>>>>>> debf1168d5ecb33f6635b84d5afbb1cedf272602
@Repository
public class StaffDao {
	
	@Autowired
	StaffRepository repository;

	public Staff savestaff(Staff staff) {
		return repository.save(staff);
	}

	public Optional<Staff> getById(int id) {
		return repository.findById(id);
	}
	public List<Staff> getAll(){
		return repository.findAll();
	}
	public String deleteOrder(Staff staff) {
		 repository.delete(staff);
		 return "Deleted";
	}
	public Staff validationByEmailAndPassword(String email, String password) {
		return repository.findByEmailAndPassword(email, password);
	}

}
