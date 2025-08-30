package com.example.ems.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ems.dto.DepartmentDto;
import com.example.ems.entity.Department;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.service.DepartmentService;

import lombok.AllArgsConstructor;

import com.example.ems.mapper.DepartmentMapper;
import com.example.ems.repository.DepartmentRepository;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department not found with id: " + id));
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List <Department> departments = departmentRepository.findAll();
        return departments.stream().map(DepartmentMapper::mapToDepartmentDto).toList();
    }

    @Override
    public DepartmentDto updateDepartment(Long id, DepartmentDto DepartmentsDto) {
        Department department = departmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department not found with id: " + id));
        department.setName(DepartmentsDto.getName());
        department.setDescription(DepartmentsDto.getDescription());
        department.setLocation(DepartmentsDto.getLocation());
        Department updatedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(updatedDepartment);
    }

    @Override
    public DepartmentDto deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department not found with id: " + id));
        departmentRepository.delete(department);
        return DepartmentMapper.mapToDepartmentDto(department);
    }
    
}
