package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.EmployeeEntity;

public interface EmployeeService {
	EmployeeEntity saveData(EmployeeEntity e);
	List<EmployeeEntity> getAllData();
	EmployeeEntity getSingleData(Integer id);
	void deleteData(Integer id);
	EmployeeEntity updateData(EmployeeEntity e1);

}
