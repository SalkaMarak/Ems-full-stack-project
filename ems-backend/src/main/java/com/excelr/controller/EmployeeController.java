package com.excelr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.dto.EmployeeDto;
import com.excelr.entity.Employee;
import com.excelr.service.EmployeeService;

@CrossOrigin("*")
@RequestMapping("/api/employees")
@RestController
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> add(@RequestBody Employee emp) {	
		EmployeeDto e = empService.addEmp(emp);
		return ResponseEntity.status(HttpStatus.CREATED).body(e);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getList() {			
		List<EmployeeDto> list = empService.getEmpList();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmp(@PathVariable int id) {
		EmployeeDto e = empService.getEmployee(id);
		return ResponseEntity.status(HttpStatus.OK).body(e);
	}
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto> update(@PathVariable int id, @RequestBody Employee emp){
		EmployeeDto e = empService.updateEmp(id, emp);
		return ResponseEntity.status(HttpStatus.OK).body(e);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		empService.deleteEmp(id);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully)");
	}
}
