package com.ty.hmsappapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hmsappapi.dto.BranchManager;
import com.ty.hmsappapi.dto.Login;
import com.ty.hmsappapi.service.BranchManagerService;
import com.ty.hmsappapi.util.ResponseStructure;

@RestController
public class BranchManagerController {
	@Autowired
	BranchManagerService service;
	@PostMapping("/branchManagers")
	public ResponseEntity<ResponseStructure<BranchManager>> saveBranchManager(@Validated @RequestBody BranchManager branchManager){		
		return service.saveBranchManager(branchManager);
	}
	
	@PutMapping("/branchManagers")
	public ResponseEntity<ResponseStructure<BranchManager>> updateBranchManager( @RequestParam int id, @RequestBody BranchManager branchManager){
		return service.updateBranchManager(id, branchManager);
	}
	@DeleteMapping("/branchManagers")
	public ResponseEntity<ResponseStructure<BranchManager>> deleteBranchManager(@RequestParam int id){
		return service.deleteBranchManager(id);
	}
	
	@GetMapping("/branchManagers/{id}")
	public ResponseEntity<ResponseStructure<BranchManager>> getBranchManager(@PathVariable int id){
		return service.getBranchManager(id);
	}
	
	@GetMapping("/branchManagers")
	public ResponseEntity<ResponseStructure<List<BranchManager>>> getAllBranchManager(){
		return service.getAllBranchManager();
	}
	@PostMapping("/branchManagers/login")
	public ResponseEntity<ResponseStructure<BranchManager>> validateBranchManager(@RequestBody Login login){
		return service.validateBranchManager(login);
		
	}
}