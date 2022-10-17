package com.ty.hmsappapi.dao;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hmsappapi.dto.Person;
import com.ty.hmsappapi.repository.PersonRepository;


@Repository
public class PersonDao {
	@Autowired
	PersonRepository repository;
	
	public Person savePerson(Person person) {
		return repository.save(person);
	}
	
	public Person upatePerson(int id, Person person) {
		Optional<Person> opt = repository.findById(id);
		if(opt.isPresent()) {
			Person p = opt.get();
			return p;
		}else {
			return null;
		}
	}
	
	
	public String deletePerson(int id) {
		Optional<Person> opt = repository.findById(id);
		if(opt.isPresent()) {
			Person person = opt.get();
			repository.delete(person);
			return "Deleted Successfully";
		}else {
			return "ID is not Exist";
		}
	}
	
	public Person getPersonById(int id) {
		Optional<Person> opt = repository.findById(id);
		if(opt.isPresent()) {
			Person p = opt.get();
			return p;
		}else {
			return null;
		}
	}
	
	public List<Person> getAllPerson(){
		return repository.findAll();
	}

}
