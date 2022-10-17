package com.ty.hmsappapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hmsappapi.dto.Encounter;
import com.ty.hmsappapi.repository.EncounterRepository;


@Repository
public class EncounterDao {
	@Autowired
	EncounterRepository repository;
	
	public Encounter saveEncounter(Encounter encounter) {
		return repository.save(encounter);
	}
	
	public Encounter upateEncounter(int id, Encounter encounter) {
		Optional<Encounter> opt = repository.findById(id);
		if(opt.isPresent()) {
			Encounter e = opt.get();
			return e;
		}else {
			return null;
		}
	}
	
	
	public String deleteEncounter(int id) {
		Optional<Encounter> opt = repository.findById(id);
		if(opt.isPresent()) {
			Encounter encounter = opt.get();
			repository.delete(encounter);
			return "Deleted Successfully";
		}else {
			return "ID is not Exist";
		}
	}
	
	public Encounter getEncounterById(int id) {
		Optional<Encounter> opt = repository.findById(id);
		if(opt.isPresent()) {
			Encounter e = opt.get();
			return e;
		}else {
			return null;
		}
	}
	
	public List<Encounter> getAllEncounter(){
		return repository.findAll();
	}

}

