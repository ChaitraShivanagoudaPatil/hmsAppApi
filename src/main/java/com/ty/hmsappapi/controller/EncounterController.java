package com.ty.hmsappapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hmsappapi.dto.Encounter;
import com.ty.hmsappapi.dto.MedOrder;
import com.ty.hmsappapi.service.EncounterService;
import com.ty.hmsappapi.util.ResponseStructure;

@RequestMapping("/encounters")
@RestController
public class EncounterController {
	@Autowired
	EncounterService service;
	@PostMapping()
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@Validated @RequestBody Encounter encounter,@RequestParam int pid,@RequestParam int bid){
		return service.saveEncounter(encounter,pid,bid);
	}
	
	@PatchMapping()
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter( @RequestParam int id, @RequestParam String status){
		return service.updateEncounter(id, status);
	}
	@DeleteMapping()
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@RequestParam int id){
		return service.deleteEncounter(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Encounter>> getEncounter(@PathVariable int id){
		return service.getEncounter(id);
	}
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<MedOrder>>> getAllMedOrdersByEncounterId(@RequestParam int eid){
		return service.getAllMedOrdersByEncounterId(eid);
	}
	
	
}