package com.ty.hmsappapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hmsappapi.dto.MedOrder;


public interface MedOrderRepository extends  JpaRepository<MedOrder, Integer>{

}
