package com.te.ems.service;

import com.te.ems.dto.ChangeProjectEDDTO;
import com.te.ems.dto.ProjectDTO;

public interface ProjectService {
	
	String saveProject(ProjectDTO projectDTO);

	boolean addProjectToEmployee(String employeeId, String projectId);

	boolean changeProjectEd(ChangeProjectEDDTO changeProjectEDDTO);

}
