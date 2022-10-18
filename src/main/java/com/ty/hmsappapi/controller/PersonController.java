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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hmsappapi.dto.Person;
import com.ty.hmsappapi.service.PersonService;
import com.ty.hmsappapi.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
@RequestMapping("/persons")
@RestController
public class PersonController {
	@Autowired
	PersonService service;
	@ApiOperation(value = "Save Person", notes = "This API is used to save person")
	@PostMapping()
	public ResponseEntity<ResponseStructure<Person>> savePerson(@Validated @RequestBody Person person){
		
		return service.savePerson(person);
	}
	
	@ApiOperation(value = "update person", notes = "This API is used to update person")
	@PutMapping()
	public ResponseEntity<ResponseStructure<Person>> updatePerson( @RequestParam int id, @RequestBody Person person){
		return service.updatePerson(id, person);
	}
	@ApiOperation(value = "delete person", notes = "This API is used to delete person")
	@DeleteMapping()
	public ResponseEntity<ResponseStructure<Person>> deletePerson(@RequestParam int id){
		return service.deletePerson(id);
	}
	
	@ApiOperation(value = "get person by id", notes = "This API is used to get person by id")
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Person>> getPerson(@PathVariable int id){
		return service.getPerson(id);
	}
	
	@ApiOperation(value = "getall person", notes = "This API is used to getall person")
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Person>>> getAllPerson(){
		return service.getAllPerson();
	}
}