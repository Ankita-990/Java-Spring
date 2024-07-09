package com.employee.mapping;

import java.util.List;

import org.mapstruct.Mapper;

import com.employee.dto.EmployeeDto;
import com.employee.model.Employee;

@Mapper
public interface EmployeeMapper {
    EmployeeDto employeeToDto(Employee employees);
    Employee dtoToEmployee(EmployeeDto dto);
}
