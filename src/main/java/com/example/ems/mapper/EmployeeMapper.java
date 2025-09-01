package com.example.ems.mapper;

import com.example.ems.dto.AddressDto;
import com.example.ems.dto.EmployeeDto;          // adjust if your DTO class has a different name
import com.example.ems.entity.Address;
import com.example.ems.entity.Employee;

public class EmployeeMapper {

    // Entity -> DTO
    public static EmployeeDto toDto(Employee e) {
        if (e == null) return null;

        EmployeeDto dto = new EmployeeDto();   // use setters to avoid needing special constructors
        dto.setId(e.getId());
        dto.setFirstName(e.getFirstName());
        dto.setLastName(e.getLastName());
        dto.setEmail(e.getEmail());

        if (e.getAddress() != null) {
            Address a = e.getAddress();
            AddressDto ad = new AddressDto();
            ad.setId(a.getId()); 
            ad.setStreet(a.getStreet());
            ad.setCity(a.getCity());
            ad.setState(a.getState());
            ad.setZipCode(a.getZipCode());
            ad.setCountry(a.getCountry());
            dto.setAddress(ad);
        }
        return dto;
    }

    // DTO -> Entity
    public static Employee toEntity(EmployeeDto dto) {
        if (dto == null) return null;

        Employee e = new Employee();
        e.setId(dto.getId());
        e.setFirstName(dto.getFirstName());
        e.setLastName(dto.getLastName());
        e.setEmail(dto.getEmail());

        if (dto.getAddress() != null) {
            AddressDto ad = dto.getAddress();
            Address a = new Address();         // JPA requires a no-args constructor
            a.setStreet(ad.getStreet());
            a.setCity(ad.getCity());
            a.setState(ad.getState());
            a.setZipCode(ad.getZipCode());
            a.setCountry(ad.getCountry());
            e.setAddress(a);                   // set the relation on the owning side
        }
        return e;
    }
}
