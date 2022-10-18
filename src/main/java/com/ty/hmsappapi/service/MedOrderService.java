package com.ty.hmsappapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hmsappapi.dao.MedOrderDao;
import com.ty.hmsappapi.dto.Item;
import com.ty.hmsappapi.dto.MedOrder;

import com.ty.hmsappapi.exception.IdnotFoundException;

import com.ty.hmsappapi.util.ResponseStructure;

@Service
public class MedOrderService {
	@Autowired
	MedOrderDao dao;

	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medOrder) {
		List<Item> list=medOrder.getList();
		double sum=0;
		for(Item i: list) {
			sum+=i.getQuantity()*i.getPrice();
		}
		medOrder.setTotalCost(sum);
		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(dao.savemedOrder(medOrder));
		return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<MedOrder>> getById(int id) {
		Optional<MedOrder> opt = dao.getById(id);
		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<MedOrder>();
		if (opt.isPresent()) {
			MedOrder medOrder = opt.get();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(medOrder);
			return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.OK);
		} else {

			throw new IdnotFoundException("Enter id " + id + " does not exist");

		}
	}

	public ResponseEntity<ResponseStructure<List<MedOrder>>> getAll() {
		List<MedOrder> list = dao.getAll();
		ResponseStructure<List<MedOrder>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(list);
		return new ResponseEntity<ResponseStructure<List<MedOrder>>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteMedOrder(int id) {
		Optional<MedOrder> opt = dao.getById(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		if (opt.isPresent()) {
			MedOrder medOrder = opt.get();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(dao.deleteOrder(medOrder));
			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		} else {

			throw new IdnotFoundException("Entered id " + id + " does not exist");

		}
	}

	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(int id, MedOrder medOrder) {
		Optional<MedOrder> opt = dao.getById(id);
		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<>();
		if (opt.isPresent()) {
			MedOrder s = opt.get();
			s.setName(medOrder.getName());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(dao.savemedOrder(s));
			return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure,HttpStatus.OK);
		}
		else {

			throw new IdnotFoundException();

		}
	}
}

