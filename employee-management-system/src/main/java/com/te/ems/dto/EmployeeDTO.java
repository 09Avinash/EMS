package com.te.ems.dto;

import java.time.LocalDate;

import com.te.ems.entity.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class EmployeeDTO {
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private Gender gender;
	private long contactNumber;
	private String email;
	private String address;

	private DepartmentDTO department;
	private PositionDTO position;
}
