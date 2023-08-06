package com.te.ems.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.te.ems.dto.EmployeeDTO;
import com.te.ems.entity.Employee;
import com.te.ems.repository.EmployeeRepository;
import com.te.ems.utils.EmployeeUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Override
	public String saveEmployee(EmployeeDTO employeeDTO) {
		log.info("Employee DTO data recived {}", employeeDTO);
		
		Employee employee = EmployeeUtils.convertToEmployeeDeptPosition(employeeDTO);
		employee.setEmployeeId(UUID.randomUUID().toString());
		
		log.info("Entity data recieved {}, {}, {}", employee.getFirstName(), 
				employee.getDepartment().getDepartmentName(), 
				employee.getPosition().getPositionName());
		
		String employeeId = employeeRepository.saveEmployee(employee);
		log.info("Returning ID");
		return employeeId;
	}

	@Override
	public boolean changeEmpPosition(String employeeId, int positionId) {
		
		return employeeRepository.changeEmpPosition(employeeId,positionId);
		
	}


}
