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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hmsappapi.dto.MedOrder;
import com.ty.hmsappapi.service.MedOrderService;
import com.ty.hmsappapi.util.ResponseStructure;

<<<<<<< HEAD

=======
>>>>>>> debf1168d5ecb33f6635b84d5afbb1cedf272602
@RestController
public class MedOrderController {
	@Autowired
	MedOrderService service;
	
	@PostMapping("/medorders")
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(@RequestBody MedOrder medOrder) {
		return service.saveMedOrder(medOrder);
	}

	@GetMapping("/medorders/{id}")
	public ResponseEntity<ResponseStructure<MedOrder>> getById(@PathVariable int id) {
		return service.getById(id);
	}

	@GetMapping("/medorders")
	public ResponseEntity<ResponseStructure<List<MedOrder>>> getAll() {
		return service.getAll();
	}

	@DeleteMapping("/medorders")
	public ResponseEntity<ResponseStructure<String>> deleteMedOrder(@RequestParam int id) {
		return service.deleteMedOrder(id);
	}

	@PutMapping("/medorders")
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@RequestParam int id, @RequestBody MedOrder medOrder) {
		return service.updateMedOrder(id, medOrder);
	}


}
