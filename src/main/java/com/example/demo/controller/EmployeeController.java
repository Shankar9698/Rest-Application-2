package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/v1")
public class EmployeeController {
	private EmployeeServiceImpl service;

	public EmployeeController(EmployeeServiceImpl service) {
		super();
		this.service = service;
	}

	@PostMapping("/save")
	public ResponseEntity<EmployeeEntity> saveToDb(@RequestBody EmployeeEntity entity) {
		return new ResponseEntity<EmployeeEntity>(service.saveData(entity), HttpStatus.CREATED);
	}

	@GetMapping("getall")
	public List<EmployeeEntity> getFromDb() {
		return service.getAllData();

	}
	@GetMapping("id/{id}")
	public ResponseEntity<EmployeeEntity> getFromDbById(@PathVariable("id") Integer id){
		return new ResponseEntity<EmployeeEntity>(service.getSingleData(id), HttpStatus.OK);
		
	}
	@DeleteMapping("id/{id}")
	public ResponseEntity<String> deleteFromDb(@PathVariable("id") Integer id){
		service.deleteData(id);
		return new ResponseEntity<String>("Employee details are deleted", HttpStatus.OK);
		
	}
	@PutMapping("id/{id}")
	public ResponseEntity<EmployeeEntity> updateToDb(@PathVariable("id") Integer id, @RequestBody EmployeeEntity entity){
		
		return new ResponseEntity<EmployeeEntity>(service.updateData(entity), HttpStatus.OK);
		
	}

}
