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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hmsappapi.dto.Login;
import com.ty.hmsappapi.dto.Staff;
import com.ty.hmsappapi.service.StaffService;
import com.ty.hmsappapi.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/staffs")
@RestController
public class StaffController {
	@Autowired
	StaffService service;
	
	@ApiOperation(value = "Save Staff", notes = "This API is used to save staff")
	@PostMapping()
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(@RequestBody Staff staff) {
		return service.saveStaff(staff);
	}
	
	@ApiOperation(value = "Get Staffby id", notes = "This API is used to get staff by id")
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Staff>> getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@ApiOperation(value = "get all Staff", notes = "This API is used to get all staff")
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Staff>>> getAll() {
		return service.getAll();
	}
	
	@ApiOperation(value = "delete Staff", notes = "This API is used to delete staff")
	@DeleteMapping()
	public ResponseEntity<ResponseStructure<String>> deleteStaff(@RequestParam int id) {
		return service.deleteStaff(id);
	}
	
	@ApiOperation(value = "update Staff", notes = "This API is used to update staff")
	@PutMapping()
	public ResponseEntity<ResponseStructure<Staff>> updateStaff(@RequestParam int id, @RequestBody Staff staff) {
		return service.updateStaff(id, staff);
	}

	@PostMapping("/login")
	public ResponseEntity<ResponseStructure<Staff>> validationByEmailAndPassword(@RequestBody Login login) {
		return service.validationByEmailAndPassword(login);
	}
}
