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

import com.ty.hmsappapi.dto.Branch;
import com.ty.hmsappapi.service.BranchService;
import com.ty.hmsappapi.util.ResponseStructure;



@RestController
public class BranchController {
    @Autowired
	BranchService branchService;
    

	@PostMapping("/branchs")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch){
		return branchService.saveBranch(branch);
	}
	@GetMapping("/branchs/{id}")
	public ResponseEntity<ResponseStructure<Branch>> getBranch(@PathVariable int id){
		return branchService.getBranch(id);
	}
	@DeleteMapping("/branchs")
	public ResponseEntity<ResponseStructure<String>> deleteBranch(@RequestParam int id){
		return branchService.deleteBranch(id);
	}
//	@GetMapping("/branchs")
//	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranch(){
//		return branchService.getAllBranch();
//	}
//	
	@PutMapping("/branchs")
	public ResponseEntity<ResponseStructure<Branch>> updateHospital(@RequestParam int id,@RequestBody Branch branch){
		return branchService.updateBranch(id, branch);
	}
	@GetMapping("/branchs")
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranch(@RequestParam int id){
		return branchService.getAllBranches(id);
}
}