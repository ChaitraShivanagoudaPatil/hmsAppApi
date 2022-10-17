package com.ty.hmsappapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hmsappapi.dto.BranchManager;
import com.ty.hmsappapi.repository.BranchManagerRepository;


@Repository
public class BranchManagerDao {
	@Autowired
	BranchManagerRepository repository;
	
	public BranchManager saveBranchManager(BranchManager branchManager) {
		return repository.save(branchManager);
	}
	
	public BranchManager upateBranchManager(int id, BranchManager branchManager) {
		Optional<BranchManager> opt = repository.findById(id);
		if(opt.isPresent()) {
			BranchManager b = opt.get();
			return b;
		}else {
			return null;
		}
	}
	
	
	public String deleteBranchManager(int id) {
		Optional<BranchManager> opt = repository.findById(id);
		if(opt.isPresent()) {
			BranchManager branchManager = opt.get();
			repository.delete(branchManager);
			return "Deleted Successfully";
		}else {
			return "ID is not Exist";
		}
	}
	
	public BranchManager getBranchManagerById(int id) {
		Optional<BranchManager> opt = repository.findById(id);
		if(opt.isPresent()) {
			BranchManager b = opt.get();
			return b;
		}else {
			return null;
		}
	}
	
	public List<BranchManager> getAllBranchManager(){
		return repository.findAll();
	}
	
	public BranchManager validateBranchManager(String email, String password) {
		return repository.findByEmailAndPassword(email, password);
	}

}
