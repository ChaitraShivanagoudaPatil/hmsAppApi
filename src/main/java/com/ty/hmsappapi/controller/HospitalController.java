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

import com.ty.hmsappapi.dto.Branch;
import com.ty.hmsappapi.dto.Hospital;
import com.ty.hmsappapi.service.HospitalService;
import com.ty.hmsappapi.util.ResponseStructure;

@RequestMapping("/hospitals")
@RestController
public class HospitalController {
	@Autowired
	HospitalService hospitalService;
	
	@PostMapping()
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital){
		return hospitalService.saveHospital(hospital);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Hospital>> getHospital(@PathVariable int id){
		return hospitalService.getHospital(id);
	}
	@DeleteMapping()
	public ResponseEntity<ResponseStructure<String>> deleteHospital(@RequestParam int id){
		return hospitalService.deleteHospital(id);
	}
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Hospital>>> getAllHospital(){
		return hospitalService.getAllHospital();
	}
	
	@PutMapping()
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestParam int id,@RequestBody Hospital hospital){
		return hospitalService.updateHospital(id, hospital);
	}
	@GetMapping("/{id}/branchs")
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranchByHospitalId(@PathVariable int hid){
		return hospitalService.getAllBranchByHospitalId(hid);
	}
	
}
