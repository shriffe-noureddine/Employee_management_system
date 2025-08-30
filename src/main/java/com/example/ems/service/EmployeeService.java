package com.example.ems.service;

import java.util.List;

import com.example.ems.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);
    EmployeeDto deleteEmployee(Long id);
}
