package com.ty.hmsappapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hmsappapi.dto.Login;
import com.ty.hmsappapi.dto.Staff;
import com.ty.hmsappapi.service.StaffService;
import com.ty.hmsappapi.util.ResponseStructure;


@RestController
public class StaffController {
	@Autowired
	StaffService service;

	@PostMapping("/staffs")
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(@RequestBody Staff staff) {
		return service.saveStaff(staff);
	}

	@GetMapping("/staffs/{id}")
	public ResponseEntity<ResponseStructure<Staff>> getById(@PathVariable int id) {
		return service.getById(id);
	}

	@GetMapping("/staffs")
	public ResponseEntity<ResponseStructure<List<Staff>>> getAll() {
		return service.getAll();
	}

	@DeleteMapping("/staffs")
	public ResponseEntity<ResponseStructure<String>> deleteStaff(@RequestParam int id) {
		return service.deleteStaff(id);
	}

	@PutMapping("/staffs")
	public ResponseEntity<ResponseStructure<Staff>> updateStaff(@RequestParam int id, @RequestBody Staff staff) {
		return service.updateStaff(id, staff);
	}

	@PostMapping("/staffs/login")
	public ResponseEntity<ResponseStructure<Staff>> validationByEmailAndPassword(@RequestBody Login login) {
		return service.validationByEmailAndPassword(login);
	}
}
