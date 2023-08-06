package com.te.ems.repository;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.te.ems.entity.Employee;
import com.te.ems.entity.Project;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Override
	public String saveProject(Project project) {

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(project);
		entityTransaction.commit();

		return project.getProjectId();
	}

	@Override
	public boolean addProjectToEmployee(String employeeId, String projectId) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Employee employee = entityManager.find(Employee.class, employeeId);
		Project project = entityManager.find(Project.class, projectId);
		employee.getProjects().add(project);
		project.getEmployees().add(employee);
		entityManager.persist(employee);
		entityTransaction.commit();
		return true;
	}

	// CHANGE THE END DATE OF PROJECT
	@Override
	public boolean changeProjectEd(Project project) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		String projectId = project.getProjectId();
		LocalDate projectEd = project.getProjectEndDate();
		Project project1 = entityManager.find(Project.class, projectId);
		project1.setProjectEndDate(projectEd);
		entityManager.persist(project1);
		entityTransaction.commit();
		return true;
	}

}
