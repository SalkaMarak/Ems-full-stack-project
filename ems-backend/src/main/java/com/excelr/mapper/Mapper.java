package com.excelr.mapper;

import com.excelr.dto.EmployeeDto;
import com.excelr.entity.Employee;

public class Mapper 
{
	public static EmployeeDto convert(Employee employee) {
		return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }
}
