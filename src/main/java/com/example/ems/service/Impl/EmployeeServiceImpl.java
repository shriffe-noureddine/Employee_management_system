package com.example.ems.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.entity.Employee;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.mapper.EmployeeMapper;
import com.example.ems.repository.EmployeeRepository;
import com.example.ems.service.EmployeeService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployeeDto(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not found with id: " + id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List <Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).toList();
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not found with id: " + id));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public EmployeeDto deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not found with id: " + id));
        employeeRepository.delete(employee);
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
    
}
