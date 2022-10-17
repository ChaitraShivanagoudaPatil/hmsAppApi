package com.ty.hmsappapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hmsappapi.dto.BranchManager;

public interface BranchManagerRepository extends JpaRepository<BranchManager, Integer>{

	BranchManager findByEmailAndPassword(String email, String password);

}
