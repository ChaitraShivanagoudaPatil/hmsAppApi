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

import com.ty.hmsappapi.dto.BranchManager;
import com.ty.hmsappapi.dto.Login;
import com.ty.hmsappapi.service.BranchManagerService;
import com.ty.hmsappapi.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RequestMapping("/branchmanagers")
@RestController
public class BranchManagerController {
	@Autowired
	BranchManagerService service;
	@ApiOperation(value = "save branchManager", notes = "This API is used to save branchManager")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@PostMapping()
	public ResponseEntity<ResponseStructure<BranchManager>> saveBranchManager(@Validated @RequestBody BranchManager branchManager){		
		return service.saveBranchManager(branchManager);
	}
	@ApiOperation(value = "update branchManager", notes = "This API is used to update branchmanager")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@PutMapping()
	public ResponseEntity<ResponseStructure<BranchManager>> updateBranchManager( @RequestParam int id, @RequestBody BranchManager branchManager){
		return service.updateBranchManager(id, branchManager);
	}
	@ApiOperation(value = "delete branchManager", notes = "This API is used to delete branchManager")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@DeleteMapping()
	public ResponseEntity<ResponseStructure<BranchManager>> deleteBranchManager(@RequestParam int id){
		return service.deleteBranchManager(id);
	}
	
	@ApiOperation(value = "get  branchManager by id", notes = "This API is used to get branchManager")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<BranchManager>> getBranchManager(@PathVariable int id){
		return service.getBranchManager(id);
	}
	
	@ApiOperation(value = "get all branchManager", notes = "This API is used to get all branchmanager")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<BranchManager>>> getAllBranchManager(){
		return service.getAllBranchManager();
	}
	@ApiOperation(value = "validate branchManager", notes = "This API is used to validate branchManager")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@PostMapping("/login")
	public ResponseEntity<ResponseStructure<BranchManager>> validateBranchManager(@RequestBody Login login){
		return service.validateBranchManager(login);
		
	}
}