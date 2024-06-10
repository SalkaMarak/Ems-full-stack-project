package com.excelr.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelr.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
