package com.example.ems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    // @GetMapping("/{id}")
    // public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
    //     EmployeeDto employeeDto = employeeService.getEmployeeById(id);
    //     return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    // }
    // @GetMapping
    // public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
    //     List<EmployeeDto> employees = employeeService.getAllEmployees();
    //     return new ResponseEntity<>(employees, HttpStatus.OK);
    // }

    // @PutMapping("/{id}")
    // public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto employeeDto) {
    //     EmployeeDto existingEmployee = employeeService.updateEmployee(id, employeeDto);
    //     return new ResponseEntity<>(existingEmployee, HttpStatus.OK);
    // }
    // @DeleteMapping("/{id}")
    // public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable("id") Long id) {
    //     EmployeeDto deletedEmployee = employeeService.deleteEmployee(id);
    //     return new ResponseEntity<>(deletedEmployee, HttpStatus.OK);
    // }
}
