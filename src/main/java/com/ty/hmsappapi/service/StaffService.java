package com.ty.hmsappapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hmsappapi.dao.StaffDao;
import com.ty.hmsappapi.dto.Login;
import com.ty.hmsappapi.dto.Staff;

import com.ty.hmsappapi.exception.IdNotFoundException;

import com.ty.hmsappapi.exception.InvalidCredentialsException;
import com.ty.hmsappapi.util.ResponseStructure;


@Service
public class StaffService {

	@Autowired
	StaffDao dao;

	public ResponseEntity<ResponseStructure<Staff>> saveStaff(Staff staff) {
		ResponseStructure<Staff> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(dao.savestaff(staff));
		return new ResponseEntity<ResponseStructure<Staff>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Staff>> getById(int id) {
		Optional<Staff> opt = dao.getById(id);
		ResponseStructure<Staff> responseStructure = new ResponseStructure<Staff>();
		if (opt.isPresent()) {
			Staff staff = opt.get();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(staff);
			return new ResponseEntity<ResponseStructure<Staff>>(responseStructure, HttpStatus.OK);
		} else {

			throw new IdNotFoundException("Enter id " + id + " does not exist");

		}
	}

	public ResponseEntity<ResponseStructure<List<Staff>>> getAll() {
		List<Staff> list = dao.getAll();
		ResponseStructure<List<Staff>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(list);
		return new ResponseEntity<ResponseStructure<List<Staff>>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteStaff(int id) {
		Optional<Staff> opt = dao.getById(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		if (opt.isPresent()) {
			Staff staff = opt.get();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(dao.deleteOrder(staff));
			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		} else {

			throw new IdNotFoundException("Entered id " + id + " does not exist");

		}
	}

	public ResponseEntity<ResponseStructure<Staff>> updateStaff(int id, Staff staff) {
		Optional<Staff> opt = dao.getById(id);
		ResponseStructure<Staff> responseStructure = new ResponseStructure<>();
		if (opt.isPresent()) {
			Staff s = opt.get();
			s.setName(staff.getName());
			s.setEmail(staff.getEmail());
			s.setPassword(staff.getPassword());
			s.setPhone(staff.getPhone());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(dao.savestaff(s));
			return new ResponseEntity<ResponseStructure<Staff>>(responseStructure,HttpStatus.OK);
		}
		else {

			throw new IdNotFoundException();

		}
	}
	public ResponseEntity<ResponseStructure<Staff>> validationByEmailAndPassword(Login login) {
		ResponseStructure<Staff> responseStructure = new ResponseStructure<>();
		Staff staff = dao.validationByEmailAndPassword(login.getEmail(), login.getPassword());
		if (staff != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESSFULL");
			responseStructure.setData(staff);
			return new ResponseEntity<ResponseStructure<Staff>>(responseStructure, HttpStatus.OK);
		} else {
			throw new InvalidCredentialsException("Invalid credetionals for email:"+login.getEmail());
		}
	}
}
