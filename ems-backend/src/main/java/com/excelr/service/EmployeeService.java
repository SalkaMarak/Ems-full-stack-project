package com.excelr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.dao.EmployeeRepository;
import com.excelr.dto.EmployeeDto;
import com.excelr.entity.Employee;
import com.excelr.mapper.Mapper;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository empRepo;
	
	//adding
	public EmployeeDto addEmp(Employee emp) {
		empRepo.save(emp);
		return Mapper.convert(emp);
	}
	//get all employees
	public List<EmployeeDto> getEmpList(){
		List<Employee> list = empRepo.findAll();
		List<EmployeeDto> dtoList = new ArrayList();
		for(Employee e : list) {
			EmployeeDto emp = new EmployeeDto(
					e.getId(),
					e.getFirstName(),
					e.getLastName(),
					e.getEmail()
					);
			dtoList.add(emp);
		}
		return dtoList;
	}
	//get employee by id
	public EmployeeDto getEmployee(int id) {
		Employee e = empRepo.findById(id).get();
		return Mapper.convert(e);
	}
	//update
	public EmployeeDto updateEmp(int id, Employee updatedEmp) {
		Employee oldEmp = empRepo.findById(id).get();
		if(updatedEmp.getFirstName() != null) oldEmp.setFirstName(updatedEmp.getFirstName());
		if(updatedEmp.getLastName() != null) oldEmp.setLastName(updatedEmp.getLastName());
		if(updatedEmp.getEmail() != null) oldEmp.setEmail(updatedEmp.getEmail());
		empRepo.save(oldEmp);
		return Mapper.convert(oldEmp);
	}
	//delete
	public void deleteEmp(int id) {
		empRepo.deleteById(id);
	}
}
