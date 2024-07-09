package com.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.master.bean.EmployeeBean;
import com.master.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{	
	@Query(value = "SELECT e.emp_id AS eid, e.emp_name AS ename , e.emp_location AS location, e.emp_age AS age, j.job_name AS jobName, d.dept_name AS deptName, e.emp_salary AS salary "
			+ " FROM employee e "
			+ " INNER JOIN department d ON e.department_id = d.id "
			+ " INNER JOIN job j ON e.job_id = j.id",
			nativeQuery = true)
	public List<EmployeeBean> getEmployeesByJoin();
	
	
	@Query(value = "SELECT e.emp_id AS eid, e.emp_name AS ename , e.emp_location AS location, e.emp_age AS age, j.job_name AS jobName, d.dept_name AS deptName, e.emp_salary AS salary "
			+ " FROM employee e "
			+ " INNER JOIN department d ON e.department_id = d.id "
			+ " INNER JOIN job j ON e.job_id = j.id "
			+ " where e.emp_id=? ",
			nativeQuery = true)
	public EmployeeBean getEmployeesJoinById(Integer id);
}
