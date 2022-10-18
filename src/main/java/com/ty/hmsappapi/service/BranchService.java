package com.ty.hmsappapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ty.hmsappapi.dao.BranchDao;
import com.ty.hmsappapi.dto.Branch;
import com.ty.hmsappapi.dto.Encounter;
import com.ty.hmsappapi.exception.IdnotFoundException;
import com.ty.hmsappapi.repository.BranchRepository;
import com.ty.hmsappapi.repository.HospitalRepository;
import com.ty.hmsappapi.util.ResponseStructure;

@Service
public class BranchService {
	@Autowired
	BranchDao branchDao;
	@Autowired
	BranchRepository branchRepository;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("SUCESSFULLY CREATED");
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Branch>> getBranch(int id) {
		if (branchDao.getBranch(id) != null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCESSFULLY CREATED");
			responseStructure.setData(branchDao.getBranch(id));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdnotFoundException("Id " + id + " doesn't exist");
		}
	}

	public ResponseEntity<ResponseStructure<String>> deleteBranch(int id) {
		if (branchDao.deleteBranch(id) != null) {
			ResponseStructure<String> responseStructure = new ResponseStructure<String>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCESSFULL");
			responseStructure.setData(branchDao.deleteBranch(id));
			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdnotFoundException("Id " + id + " doesn't exist");

		}
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int id, Branch branch) {
		Optional<Branch> opt = branchRepository.findById(id);
		ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
		if (opt.isPresent()) {
			Branch ref = opt.get();
			ref.setCity(branch.getCity());
			ref.setAddress(branch.getAddress());
			ref.setPhone(branch.getPhone());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCESSFULL");
			responseStructure.setData(branchDao.saveBranch(ref));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdnotFoundException("Id " + id + " doesn't exist");
		}
	}


	

	public ResponseEntity<ResponseStructure<List<Encounter>>> getAllEncounterByBranchId(int bid) {
		Branch branch = branchDao.getBranch(bid);
		List<Encounter> list=branch.getEncounter();
		ResponseStructure<List<Encounter>> responseStructure = new ResponseStructure<List<Encounter>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(list);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}
	
//    public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranch(){
//        ResponseStructure<List<Branch>> responseStructure= new ResponseStructure<List<Branch>>();
//        responseStructure.setStatus(HttpStatus.OK.value());
//        responseStructure.setMessage("SUCESSFULL");
//        responseStructure.setData(branchDao.getAllBranch());
//        return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure,HttpStatus.OK);
//    }
    public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranches(int id){
    	 ResponseStructure<List<Branch>> responseStructure= new ResponseStructure<List<Branch>>();
         responseStructure.setStatus(HttpStatus.OK.value());
         responseStructure.setMessage("SUCESSFULL");
         responseStructure.setData(branchDao.getAllBranchs(id));
         return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure,HttpStatus.OK);
    }
}