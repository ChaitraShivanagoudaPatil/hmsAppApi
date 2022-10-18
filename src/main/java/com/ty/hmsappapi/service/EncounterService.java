package com.ty.hmsappapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ty.hmsappapi.dao.BranchDao;
import com.ty.hmsappapi.dao.EncounterDao;
import com.ty.hmsappapi.dao.MedOrderDao;
import com.ty.hmsappapi.dao.PersonDao;
import com.ty.hmsappapi.dto.Branch;
import com.ty.hmsappapi.dto.Encounter;
import com.ty.hmsappapi.dto.MedOrder;
import com.ty.hmsappapi.dto.Person;
import com.ty.hmsappapi.exception.IdnotFoundException;
import com.ty.hmsappapi.repository.EncounterRepository;
import com.ty.hmsappapi.repository.PersonRepository;
import com.ty.hmsappapi.util.ResponseStructure;

@Service
public class EncounterService {
	@Autowired
	EncounterDao dao;
	@Autowired
	EncounterRepository repository;
	@Autowired
	PersonDao personDao;
	@Autowired
	BranchDao branchDao;
	

	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter, int pid, int bid) {
		Person person = personDao.getPersonById(pid);
		Branch branch=branchDao.getBranch(bid);
		encounter.setPerson(person);
		encounter.setBranch(branch);
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(dao.saveEncounter(encounter));
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(int id, String status) {
		Optional<Encounter> opt = repository.findById(id);
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
		if (opt.isPresent()) {

			Encounter res = opt.get();
			res.setStatus(status);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");

			responseStructure.setData(dao.saveEncounter(res));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdnotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int id) {
		Optional<Encounter> opt = repository.findById(id);
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
		if (opt.isPresent()) {
			Encounter encounter = new Encounter();
			repository.delete(encounter);

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("DELETED");

			responseStructure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("NOT DELETED");
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

//	public ResponseEntity<ResponseStructure<List<Encounter>>> getAllEncounterByBranchId(int bid) {
//		ResponseStructure<List<Encounter>> responseStructure = new ResponseStructure<List<Encounter>>();
//		responseStructure.setStatus(HttpStatus.OK.value());
//		responseStructure.setMessage("SUCCESS");
//		responseStructure.setData(repository.findAll());
//		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
//	}

	public ResponseEntity<ResponseStructure<Encounter>> getEncounter(@PathVariable int id) {
		Optional<Encounter> opt = repository.findById(id);
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
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
	public ResponseEntity<ResponseStructure<List<MedOrder>>> getAllMedOrdersByEncounterId(int eid){
		Encounter encounter=dao.getEncounterById(eid);
	//	List<MedOrder> list=encounter.getMedOrders();
		ResponseStructure<List<MedOrder>> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(null);
	//	responseStructure.setData(list);
		return new ResponseEntity<>(responseStructure,HttpStatus.OK);
		
	}
}
