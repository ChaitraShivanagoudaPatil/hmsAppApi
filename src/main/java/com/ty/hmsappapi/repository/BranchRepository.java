package com.ty.hmsappapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.hmsappapi.dto.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer> {

	@Query(value = "SELECT b FROM Branch b WHERE b.hospital.id=id")
	public List<Branch> getAllBranch(int id);
}

