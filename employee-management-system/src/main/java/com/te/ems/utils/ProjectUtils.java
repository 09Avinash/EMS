package com.te.ems.utils;

import com.te.ems.dto.ProjectDTO;
import com.te.ems.entity.Project;

public class ProjectUtils {
	public static Project convertProjectDTOtoProjectEnt(ProjectDTO projectDTO) {

		Project project = Project.builder()
				.projectName(projectDTO.getProjectName())
				.projectStartDate(projectDTO.getProjectStartDate())
				.projectEndDate(projectDTO.getProjectEndDate())
				.build();
		project.setCompleted(projectDTO.isCompleted());

		return project;
	}
}
