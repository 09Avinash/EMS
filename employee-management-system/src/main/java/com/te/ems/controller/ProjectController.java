package com.te.ems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.ems.constant.EmployeeConstant;
import com.te.ems.dto.ChangeProjectEDDTO;
import com.te.ems.dto.ProjectDTO;
import com.te.ems.response.SuccessResponse;
import com.te.ems.service.ProjectService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/project")
@RestController
public class ProjectController {

	private final ProjectService projectService;

	@PostMapping(path = "/")
	public ResponseEntity<SuccessResponse<String>> saveProject(@RequestBody ProjectDTO projectDTO) {

		String projectId = projectService.saveProject(projectDTO);

		return ResponseEntity.status(HttpStatus.CREATED)
							.body(SuccessResponse.<String>builder()
													.data(projectId)
													.message(EmployeeConstant.PROJECT_SAVED)
													.build());

	}

	@PutMapping(path = "/addproject-to-employee")
	public ResponseEntity<SuccessResponse<Boolean>> addProjectToEmployee(
			@RequestParam("employeeId") String employeeId,
			@RequestParam("projectId") String projectId) {
		
		boolean isAdded = projectService.addProjectToEmployee(employeeId, projectId);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(SuccessResponse.<Boolean>builder()
						.data(isAdded)
						.message(EmployeeConstant.PROJECT_SAVED)
						.build());
	}

	// CHANGE PROJECT END DATE
	@PatchMapping(path = "/change-end-date")
	public ResponseEntity<SuccessResponse<Boolean>> changeProjectEd(ChangeProjectEDDTO changeProjectEDDTO) {

		boolean isSaved = projectService.changeProjectEd(changeProjectEDDTO);

		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(SuccessResponse.<Boolean>builder()
									.data(isSaved)
									.message(EmployeeConstant.PROJECT_SAVED)
									.build());
	}

}
