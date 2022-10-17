package com.ty.hmsappapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ty.hmsappapi.dao.EncounterDao;
import com.ty.hmsappapi.dto.Encounter;
import com.ty.hmsappapi.exception.IdnotFoundException;
import com.ty.hmsappapi.repository.EncounterRepository;
import com.ty.hmsappapi.util.ResponseStructure;

@Service
public class EncounterService {
	@Autowired
	EncounterDao dao;
	@Autowired
	EncounterRepository repository;

	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@RequestBody Encounter encounter) {
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(dao.saveEncounter(encounter));
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(int id, Encounter encounter) {
		Optional<Encounter> opt = repository.findById(id);
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
		if (opt.isPresent()) {

			Encounter res = opt.get();
			res.setDate(encounter.getDate());
			res.setCause(encounter.getCause());
			res.setPriority(encounter.getPriority());

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

	public ResponseEntity<ResponseStructure<List<Encounter>>> getAllEncounter() {
		ResponseStructure<List<Encounter>> responseStructure = new ResponseStructure<List<Encounter>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(repository.findAll());
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

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
}
