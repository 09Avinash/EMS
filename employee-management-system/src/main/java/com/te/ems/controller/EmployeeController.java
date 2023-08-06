package com.te.ems.controller;

import static com.te.ems.constant.EmployeeConstant.EMPLOYEE_SAVED;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.ems.constant.EmployeeConstant;
import com.te.ems.dto.DepartmentDTO;
import com.te.ems.dto.EmployeeDTO;
import com.te.ems.dto.PositionDTO;
import com.te.ems.response.SuccessResponse;
import com.te.ems.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/employee")
@RestController
public class EmployeeController {

	private final EmployeeService employeeService;

	@GetMapping(path = "/try")
	public SuccessResponse<EmployeeDTO> name() {
		EmployeeDTO employeeDTO = EmployeeDTO
									.builder()
									.dateOfBirth(LocalDate.now())
									.department(DepartmentDTO.builder().build())
									.position(PositionDTO.builder().build()).build();
		
		return SuccessResponse.<EmployeeDTO>builder()
							.data(employeeDTO)
							.build();
	}

	@PostMapping(path = "/")
	public ResponseEntity<SuccessResponse<String>> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
		
		log.info("saveEmployee() execution started");
		String employeeId = employeeService.saveEmployee(employeeDTO);
		
		log.info("ID of the employee recieved, sending response");
		
		return ResponseEntity.status(HttpStatus.CREATED)
							.body(SuccessResponse
									.<String>builder()
									.data(employeeId)
									.message(EMPLOYEE_SAVED)
									.build()
									);
	}

	// CHANGE POSITION OF THE EMPLOYEE
	@PatchMapping(path = "/change-position")
	public ResponseEntity<SuccessResponse<Boolean>> changeEmpPosition(@RequestParam("employeeId") String employeeId,
																		@RequestParam("positionId") int positionId) {
	
		boolean isChanged = employeeService.changeEmpPosition(employeeId, positionId);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED)
							.body(SuccessResponse
									.<Boolean>builder()
									.data(isChanged)
									.message(EmployeeConstant.POSITION_SAVED)
									.build()
									);

	}

}
