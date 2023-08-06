package com.te.ems.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Employee {
	@Id
	private String employeeId;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private long contactNumber;
	private String email;
	private String address;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Department department;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Position position;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Salary salary;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Attendence> attendences;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Project> projects;

}
