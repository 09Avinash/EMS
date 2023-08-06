package com.te.ems.utils;

import com.te.ems.dto.EmployeeDTO;
import com.te.ems.entity.Department;
import com.te.ems.entity.Employee;
import com.te.ems.entity.Position;

public class EmployeeUtils {
	public static Employee convertToEmployeeDeptPosition(EmployeeDTO employeeDTO) {
		return Employee.builder()
		.email(employeeDTO.getEmail())
		.firstName(employeeDTO.getFirstName())
		.lastName(employeeDTO.getLastName())
		.contactNumber(employeeDTO.getContactNumber())
		.gender(employeeDTO.getGender())
		.dateOfBirth(employeeDTO.getDateOfBirth())
		.address(employeeDTO.getAddress())
		.department(
				Department.builder()
				.departmentName(employeeDTO.getDepartment()
						.getDepartmentName())
				.build()
		)
		.position(
				Position.builder()
				.positionName(employeeDTO.getPosition().getPositionName())
				.build()
		).build();
	}
}
