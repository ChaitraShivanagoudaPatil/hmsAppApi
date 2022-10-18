package com.ty.hmsappapi.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hmsappapi.dto.MedOrder;
import com.ty.hmsappapi.repository.MedOrderRepository;


@Repository
public class MedOrderDao {
	
	@Autowired
	MedOrderRepository repository;

	public MedOrder savemedOrder(MedOrder medOrder) {
		return repository.save(medOrder);
	}

	public Optional<MedOrder> getById(int id) {
		return repository.findById(id);
	}
	public List<MedOrder> getAll(){
		return repository.findAll();
	}
	public String deleteOrder(MedOrder medOrder) {
		 repository.delete(medOrder);
		 return "Deleted";
	}

}
