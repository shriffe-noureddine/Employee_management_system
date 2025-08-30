package com.example.ems.mapper;

import com.example.ems.dto.DepartmentDto;
import com.example.ems.entity.Department;

public class DepartmentMapper {
    public static DepartmentDto mapToDepartmentDto(Department department) {

        return new DepartmentDto(
                department.getId(),
                department.getName(),
                department.getDescription(),
                department.getLocation()
        );
    }
    public static Department mapToDepartment(DepartmentDto departmentDto) {
        return new Department(
                departmentDto.getId(),
                departmentDto.getName(),
                departmentDto.getDescription(),
                departmentDto.getLocation()
        );
    }
}
