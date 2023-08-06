package com.te.ems.repository;

import java.util.List;

import com.te.ems.entity.Employee;

public interface EmployeeRepository {

	String saveEmployee(Employee employee);

	boolean changeEmpPosition(String employeeId, int positionId);

	List<Employee> fetchEmployees();

}
