package com.te.ems.service;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.te.ems.dto.ChangeProjectEDDTO;
import com.te.ems.dto.ProjectDTO;
import com.te.ems.entity.Project;
import com.te.ems.repository.ProjectRepository;
import com.te.ems.utils.ProjectUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {

	private final ProjectRepository projectRepository;

	@Override
	public String saveProject(ProjectDTO projectDTO) {
		Project project = ProjectUtils.convertProjectDTOtoProjectEnt(projectDTO);
		project.setProjectId(UUID.randomUUID().toString());

		String projectId = projectRepository.saveProject(project);
		return projectId;
	}

	@Override
	public boolean addProjectToEmployee(String employeeId, String projectId) {

		return projectRepository.addProjectToEmployee(employeeId, projectId);
	}

	@Override
	public boolean changeProjectEd(ChangeProjectEDDTO changeProjectEDDTO) {
		String projectId = changeProjectEDDTO.getProjectId();
		LocalDate projectEd = changeProjectEDDTO.getProjectEndDate();
		
		Project project=Project.builder()
				.projectId(changeProjectEDDTO.getProjectId())
				.projectEndDate(changeProjectEDDTO.getProjectEndDate())
				.build();

		return projectRepository.changeProjectEd(project);
	}

}
