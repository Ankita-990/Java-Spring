package com.master.service.impl;

import java.util.List;	
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.bean.EmployeeBean;
import com.master.dto.EmployeeDto;
import com.master.entity.Employee;
import com.master.mapping.MapEmployeeDto;
import com.master.repository.DepartmentRepository;
import com.master.repository.EmployeeRepository;
import com.master.repository.JobRepository;
import com.master.service.ServiceEmployee;

@Service
public class ServiceEmployeeImpl implements ServiceEmployee
{
	@Autowired
	EmployeeRepository employeeDao;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	DepartmentRepository departmentDao;
	
	@Autowired
	JobRepository jobDao;
	
	@Autowired
	MapEmployeeDto employeeDto;

	// Add new Employee
	@Override
	public EmployeeDto addEmployee(EmployeeDto dto) {
		Employee employee = employeeDto.dtoToEmployee(dto);
		employeeDao.save(employee);
		return employeeDto.employeeToDto(employee);
	}

	@Override
	public List<EmployeeDto> fetchAllEmployee() {
		List<Employee> list = employeeDao.findAll();
		List<EmployeeDto> listDto = list.stream()
			.map(emp -> employeeDto.employeeToDto(emp))
			.collect(Collectors.toList());
		return listDto;
	}

	@Override
	public EmployeeDto fetchEmployeeById(int id) {
		Optional<Employee> find = employeeDao.findById(id);
		Employee employee =  find.get();
		return employeeDto.employeeToDto(employee);
	}

	@Override
	public EmployeeDto updateEmployee(int id, EmployeeDto dto) {
		Optional<Employee> search = employeeDao.findById(id);
		Employee employee = search.get();
		
		Employee updateEmployee = Employee.builder()
				.eid(employee.getEid())
				.ename(dto.getEname())
				.location(dto.getLocation())
				.age(dto.getAge())
				.job(dto.getJob())
				.department(dto.getDepartment())
				.salary(dto.getSalary())
				.build();
		employeeDao.save(updateEmployee);
		return employeeDto.employeeToDto(updateEmployee);
	}

	@Override
	public void deleteEmployee(int id) {
		employeeDao.deleteById(id);
	}

	@Override
	public List<EmployeeBean> joinTable() {
		return employeeDao.getEmployeesByJoin();
	}

	@Override
	public EmployeeBean joinTableById(Integer id) {
		return employeeDao.getEmployeesJoinById(id);
	}
	
	
}
