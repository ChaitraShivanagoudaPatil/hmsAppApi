package com.ty.hmsappapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ty.hmsappapi.dto.MedOrder;
<<<<<<< HEAD
import com.ty.hmsappapi.repository.MedOrderRepository;
=======
import com.ty.hmsappapi.respository.MedOrderRepository;
>>>>>>> debf1168d5ecb33f6635b84d5afbb1cedf272602

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
