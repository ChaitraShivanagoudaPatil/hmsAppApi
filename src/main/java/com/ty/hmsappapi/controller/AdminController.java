package com.ty.hmsappapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hmsappapi.dao.Login;
import com.ty.hmsappapi.dto.Admin;
import com.ty.hmsappapi.service.AdminService;
import com.ty.hmsappapi.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;


@RequestMapping("/admins")
@RestController
public class AdminController {
	@Autowired
	AdminService adminService;
	@ApiOperation(value = "save admin", notes = "This API is used to save admin")
	@PostMapping()
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@Validated@RequestBody Admin admin){
		return adminService.saveAdmin(admin);
	}
	@ApiOperation(value = "get admin", notes = "This API is used to get admin")
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Admin>> getAdmin(@RequestParam int id){
		return adminService.getAdmin(id);
	}
	@ApiOperation(value = "delete admin", notes = "This API is used to delete admin")
	@DeleteMapping()
	public ResponseEntity<ResponseStructure<String>> deleteAdmin(int id){
		return adminService.deleteAdmin(id);
	}
	@ApiOperation(value = "update admin", notes = "This API is used to update admin")
	@PutMapping()
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestParam int id,@Validated@RequestBody Admin admin){
		return adminService.updateAdmin(id, admin);
	}
	@ApiOperation(value = "list of admin", notes = "This API is used to list of admin")
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Admin>>> getAllAdmin(){
		return adminService.getAllAdmin();
	}
	@ApiOperation(value = "validate admin", notes = "This API is used to validate admin")
	@PostMapping("/login")
	public ResponseEntity<ResponseStructure<Admin>> validateUser(@RequestBody Login login){
		return adminService.validateAdmin(login);
		
	}
	
	

}
