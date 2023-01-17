package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository repo;

	@Override
	public EmployeeEntity saveData(EmployeeEntity e) {

		return repo.save(e);
	}

	@Override
	public List<EmployeeEntity> getAllData() {

		return repo.findAll();
	}

	@Override
	public EmployeeEntity getSingleData(Integer id) {
//		Optional<EmployeeEntity> e1 = repo.findById(id);
//		if (e1.isPresent()) {
//			return e1.get();
//
//		}
//		else
//		{
//			throw new EmployeeNotFoundException(id+" is not matching with DB");
//		}
		return repo.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id + " is not present in DB try with another id to get the data"));
	}

	@Override
	public void deleteData(Integer id) {
		repo.findById(id).orElseThrow(()->new EmployeeNotFoundException(id+" is not present in DB try with another id to delete the data"));
		repo.deleteById(id);

	}

	@Override
	public EmployeeEntity updateData(EmployeeEntity e1) {
		EmployeeEntity e2=repo.findById(e1.getEid()).orElseThrow(()-> new EmployeeNotFoundException(e1.getEid()+"is not present in DB try with another id to update the data"));
		e2.setEid(e1.getEid());
		e2.setEname(e1.getEname());
		e2.setEloc(e1.getEloc());
		e2.setEyoe(e1.getEyoe());
		repo.save(e2);
		return e2;
	}

}
