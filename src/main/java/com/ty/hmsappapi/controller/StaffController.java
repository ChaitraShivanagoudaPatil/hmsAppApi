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
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/staffs")
@RestController
public class StaffController {
	@Autowired
	StaffService service;
	
	@ApiOperation(value = "Save Staff", notes = "This API is used to save staff")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@PostMapping()
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(@RequestBody Staff staff) {
		return service.saveStaff(staff);
	}
	
	@ApiOperation(value = "Get Staffby id", notes = "This API is used to get staff by id")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Staff>> getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@ApiOperation(value = "get all Staff", notes = "This API is used to get all staff")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Staff>>> getAll() {
		return service.getAll();
	}
	
	@ApiOperation(value = "delete Staff", notes = "This API is used to delete staff")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@DeleteMapping()
	public ResponseEntity<ResponseStructure<String>> deleteStaff(@RequestParam int id) {
		return service.deleteStaff(id);
	}
	
	@ApiOperation(value = "update Staff", notes = "This API is used to update staff")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@PutMapping()
	public ResponseEntity<ResponseStructure<Staff>> updateStaff(@RequestParam int id, @RequestBody Staff staff) {
		return service.updateStaff(id, staff);
	}
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@PostMapping("/login")
	public ResponseEntity<ResponseStructure<Staff>> validationByEmailAndPassword(@RequestBody Login login) {
		return service.validationByEmailAndPassword(login);
	}
}
