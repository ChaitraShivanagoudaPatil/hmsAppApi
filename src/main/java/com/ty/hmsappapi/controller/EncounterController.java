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

import com.ty.hmsappapi.dto.Encounter;
import com.ty.hmsappapi.service.EncounterService;
import com.ty.hmsappapi.util.ResponseStructure;

@RestController
public class EncounterController {
	@Autowired
	EncounterService service;
	@PostMapping("/encounters")
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@Validated @RequestBody Encounter encounter){
		
		return service.saveEncounter(encounter);
	}
	
	@PutMapping("/encounters")
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter( @RequestParam int id, @RequestBody Encounter encounter){
		return service.updateEncounter(id, encounter);
	}
	@DeleteMapping("/encounters")
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@RequestParam int id){
		return service.deleteEncounter(id);
	}
	
	@GetMapping("/encounters/{id}")
	public ResponseEntity<ResponseStructure<Encounter>> getEncounter(@PathVariable int id){
		return service.getEncounter(id);
	}
	
	@GetMapping("/encounters")
	public ResponseEntity<ResponseStructure<List<Encounter>>> getAllEncounter(){
		return service.getAllEncounter();
	}
}