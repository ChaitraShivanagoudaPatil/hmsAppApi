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
import com.ty.hmsappapi.dto.Encounter;
import com.ty.hmsappapi.service.BranchService;
import com.ty.hmsappapi.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/branchs")
@RestController
public class BranchController {

	@Autowired
	private BranchService branchService;
	@ApiOperation(value = "save branch", notes = "This API is used to save branch")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@PostMapping()
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}
	@ApiOperation(value = "get branch by id", notes = "This API is used to get branch by id")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Branch>> getBranch(@PathVariable int id) {
		return branchService.getBranch(id);
	}
	@ApiOperation(value = "delete branch", notes = "This API is used to delete branch")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@DeleteMapping()
	public ResponseEntity<ResponseStructure<String>> deleteBranch(@RequestParam int id) {
		return branchService.deleteBranch(id);
	}

	@ApiOperation(value = "update branch", notes = "This API is used to update branch")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@PutMapping()
	public ResponseEntity<ResponseStructure<Branch>> updateHospital(@RequestParam int id, @RequestBody Branch branch) {
		return branchService.updateBranch(id, branch);
	}
	@ApiOperation(value = "get all branch", notes = "This API is used to get all branch")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranch(@RequestParam int id){
		return branchService.getAllBranches(id);
}
	@ApiOperation(value = "get encounter by branchid", notes = "This API is used to encounter by branchid")
	@ApiResponses(value= {@ApiResponse(code=200,message="successfull"),
    	    @ApiResponse(code=400,message="SUCCESSFULL"),
    	    @ApiResponse(code=401,message="NOT AUTHORISED"),
    	    @ApiResponse(code=403,message="ACCESS FORBIDDEN"),
    	    @ApiResponse(code=404,message="GIVEN ID NOT FOUND"),
    	    @ApiResponse(code=405,message="METHOD NOT SUPPORTED")})
	@GetMapping("/{bid}")
	public ResponseEntity<ResponseStructure<List<Encounter>>> getAllEncounterByBranchId(@PathVariable int bid){
		return branchService.getAllEncounterByBranchId(bid);
	}

}