package com.te.ems.repository;

import java.time.LocalDate;

import com.te.ems.entity.Project;

public interface ProjectRepository {

	String saveProject(Project project);

	boolean addProjectToEmployee(String employeeId, String projectId);

	boolean changeProjectEd(Project  project);

}
