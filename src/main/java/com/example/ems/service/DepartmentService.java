package com.example.ems.service;

import java.util.List;

import com.example.ems.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto DepartmentsDto);
    DepartmentDto getDepartmentById(Long id);
    List<DepartmentDto> getAllDepartments();
    DepartmentDto updateDepartment(Long id, DepartmentDto DepartmentsDto);
    DepartmentDto deleteDepartment(Long id);
}
