package com.ty.hmsappapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hmsappapi.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
