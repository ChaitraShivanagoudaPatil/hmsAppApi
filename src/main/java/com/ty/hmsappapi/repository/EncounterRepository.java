package com.ty.hmsappapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hmsappapi.dto.Encounter;

public interface EncounterRepository extends JpaRepository<Encounter, Integer>{

}
