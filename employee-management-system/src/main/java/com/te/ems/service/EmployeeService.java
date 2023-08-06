package com.te.ems.service;

import com.te.ems.dto.EmployeeDTO;

public interface EmployeeService {

	String saveEmployee(EmployeeDTO employeeDTO);

	boolean changeEmpPosition(String employeeId, int positionId);


}
