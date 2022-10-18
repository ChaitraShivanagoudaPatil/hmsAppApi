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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/hospitals")
@RestController
public class HospitalController {
	@Autowired
	HospitalService hospitalService;
	@ApiOperation(value ="save hospital", notes = "This API is used to save hospital")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@PostMapping()
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital){
		return hospitalService.saveHospital(hospital);
	}
	@ApiOperation(value = "get Hospital by id", notes = "This API is used to get Hospital by id")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Hospital>> getHospital(@PathVariable int id){
		return hospitalService.getHospital(id);
	}
	@ApiOperation(value = "delete Hospital by id", notes = "This API is used to delete Hospital by id")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@DeleteMapping()
	public ResponseEntity<ResponseStructure<String>> deleteHospital(@RequestParam int id){
		return hospitalService.deleteHospital(id);
	}
	@ApiOperation(value = "getAll Hospital", notes = "This API is used to getAll Hospitals")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Hospital>>> getAllHospital(){
		return hospitalService.getAllHospital();
	}
	@ApiOperation(value = "update Hospital ", notes = "This API is used to update Hospital")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@PutMapping()
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestParam int id,@RequestBody Hospital hospital){
		return hospitalService.updateHospital(id, hospital);
	}
	@ApiOperation(value = "get all branches", notes = "This API is used to get All branchs by Hospital  id")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@GetMapping("/{id}/branchs")
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranchByHospitalId(@PathVariable int hid){
		return hospitalService.getAllBranchByHospitalId(hid);
	}
	
}
