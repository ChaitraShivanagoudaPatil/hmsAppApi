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

import com.ty.hmsappapi.dto.MedOrder;
import com.ty.hmsappapi.service.MedOrderService;
import com.ty.hmsappapi.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/medorders")
@RestController
public class MedOrderController {
	@Autowired
	MedOrderService service;
	//save medorder by encounter id
	@ApiOperation(value = "save medorder", notes = "This API is used to save medorder")
	@PostMapping()
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(@RequestBody MedOrder medOrder) {
		return service.saveMedOrder(medOrder);
	}
	
	@ApiOperation(value = "get medorder by id", notes = "This API is used to get medorder by id")
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<MedOrder>> getById(@PathVariable int id) {
		return service.getById(id);
	}
	//get all medorder by encounter id
	
	@ApiOperation(value = "delete medorder", notes = "This API is used to delete medorder")
	@DeleteMapping()
	public ResponseEntity<ResponseStructure<String>> deleteMedOrder(@RequestParam int id) {
		return service.deleteMedOrder(id);
	}
	
	@ApiOperation(value = "update medorder", notes = "This API is used to update medorder")
	@PutMapping()
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@RequestParam int id, @RequestBody MedOrder medOrder) {
		return service.updateMedOrder(id, medOrder);
	}


}
