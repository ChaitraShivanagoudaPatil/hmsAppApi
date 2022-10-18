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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hmsappapi.dto.Encounter;
import com.ty.hmsappapi.service.EncounterService;
import com.ty.hmsappapi.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EncounterController {
	@Autowired
	EncounterService service;
	
	@ApiOperation(value = "save encounter", notes = "This API is used to save encounter")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@PostMapping("/encounters")
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@RequestParam int bid,@RequestParam int pid ,@Validated @RequestBody Encounter encounter){
		return service.saveEncounter(encounter, bid, pid);
	}
	
	@ApiOperation(value = "update encounter", notes = "This API is used to update encounter")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@PatchMapping("/encounters")
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter( @RequestParam int id, @RequestBody String status){
		return service.updateEncounter(id, status);
	}
	
	@ApiOperation(value = "delete encounter", notes = "This API is used to delete encounter")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@DeleteMapping("/encounters")
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@RequestParam int id){
		return service.deleteEncounter(id);
	}
	
	@ApiOperation(value = "get encounter by id", notes = "This API is used to get encounter by id")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@GetMapping("/encounters/{id}")
	public ResponseEntity<ResponseStructure<Encounter>> getEncounter(@PathVariable int id){
		return service.getEncounter(id);
	}
	
//	@GetMapping("/encounters")
//	public ResponseEntity<ResponseStructure<List<Encounter>>> getAllEncounter(){
//		return service.getAllEncounter();
//	}
}