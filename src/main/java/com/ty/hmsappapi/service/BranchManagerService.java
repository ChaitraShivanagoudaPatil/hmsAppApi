package com.ty.hmsappapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ty.hmsappapi.dao.BranchManagerDao;
import com.ty.hmsappapi.dto.BranchManager;
import com.ty.hmsappapi.dto.Login;
import com.ty.hmsappapi.exception.IdnotFoundException;
import com.ty.hmsappapi.exception.InvalidCredentialsException;
import com.ty.hmsappapi.repository.BranchManagerRepository;
import com.ty.hmsappapi.util.ResponseStructure;

@Service
public class BranchManagerService {
	@Autowired
	BranchManagerDao dao;
	@Autowired
	BranchManagerRepository repository;

	public ResponseEntity<ResponseStructure<BranchManager>> saveBranchManager(@RequestBody BranchManager branchManager) {
		ResponseStructure<BranchManager> responseStructure = new ResponseStructure<BranchManager>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(dao.saveBranchManager(branchManager));
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<BranchManager>> updateBranchManager(int id, BranchManager branchManager) {
		Optional<BranchManager> opt = repository.findById(id);
		ResponseStructure<BranchManager> responseStructure = new ResponseStructure<BranchManager>();
		if (opt.isPresent()) {

			BranchManager res = opt.get();
			res.setName(branchManager.getName());
			res.setPassword(branchManager.getPassword());
			res.setPhone(branchManager.getPhone());
			res.setEmail(branchManager.getEmail());
			res.setAddress(branchManager.getAddress());

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");

			responseStructure.setData(dao.saveBranchManager(res));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdnotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<BranchManager>> deleteBranchManager(int id) {
		Optional<BranchManager> opt = repository.findById(id);
		ResponseStructure<BranchManager> responseStructure = new ResponseStructure<BranchManager>();
		if (opt.isPresent()) {
			BranchManager branchManager = new BranchManager();
			repository.delete(branchManager);

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("DELETED");

			responseStructure.setData(branchManager);
			return new ResponseEntity<ResponseStructure<BranchManager>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("NOT DELETED");
			return new ResponseEntity<ResponseStructure<BranchManager>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<List<BranchManager>>> getAllBranchManager() {
		ResponseStructure<List<BranchManager>> responseStructure = new ResponseStructure<List<BranchManager>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(repository.findAll());
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	 public ResponseEntity<ResponseStructure<BranchManager>> getBranchManager(@PathVariable int id) {
		Optional<BranchManager> opt = repository.findById(id);
		ResponseStructure<BranchManager> responseStructure = new ResponseStructure<BranchManager>();
		if (opt.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(opt.get());
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("ID NOT FOUND");
			responseStructure.setData(null);
			return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<BranchManager>> validateBranchManager(Login login){
		BranchManager branchManager = dao.validateBranchManager(login.getEmail(), login.getPassword());
		ResponseStructure<BranchManager> responseStructure = new ResponseStructure<BranchManager>();
		if (branchManager !=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(branchManager);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new InvalidCredentialsException("Invalid credentials");
		}
	}
}
