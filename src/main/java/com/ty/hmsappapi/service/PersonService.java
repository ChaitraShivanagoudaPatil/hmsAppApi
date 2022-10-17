package com.ty.hmsappapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ty.hmsappapi.dao.PersonDao;
import com.ty.hmsappapi.dto.Person;
import com.ty.hmsappapi.exception.IdnotFoundException;
import com.ty.hmsappapi.repository.PersonRepository;
import com.ty.hmsappapi.util.ResponseStructure;

@Service
public class PersonService {
	@Autowired
	PersonDao dao;
	@Autowired
	PersonRepository repository;

	public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody Person person) {
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(dao.savePerson(person));
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Person>> updatePerson(int id, Person person) {
		Optional<Person> opt = repository.findById(id);
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		if (opt.isPresent()) {

			Person res = opt.get();
			res.setName(person.getName());
			res.setGender(person.getGender());
			res.setPhone(person.getPhone());
			res.setEmail(person.getEmail());
			res.setAge(person.getAge());

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");

			responseStructure.setData(dao.savePerson(res));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdnotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<Person>> deletePerson(int id) {
		Optional<Person> opt = repository.findById(id);
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		if (opt.isPresent()) {
			Person person = new Person();
			repository.delete(person);

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("DELETED");

			responseStructure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("NOT DELETED");
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<List<Person>>> getAllPerson() {
		ResponseStructure<List<Person>> responseStructure = new ResponseStructure<List<Person>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(repository.findAll());
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Person>> getPerson(@PathVariable int id) {
		Optional<Person> opt = repository.findById(id);
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
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


