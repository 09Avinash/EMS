package com.te.ems.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.ems.entity.Employee;
import com.te.ems.entity.Position;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Override
	public String saveEmployee(Employee employee) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee.getEmployeeId();
	}

	@Override
	public boolean changeEmpPosition(String employeeId, int positionId) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Employee employee = entityManager.find(Employee.class, employeeId);
		Position position = entityManager.find(Position.class, positionId);
		employee.setPosition(position);
		entityManager.persist(employee);
		entityTransaction.commit();
		return true;
	}

	@Override
	public List fetchEmployees() {

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query nativeQuery = entityManager.createQuery("select e from Employee e");
		List resultList = nativeQuery.getResultList();
		return resultList;
	}

}
