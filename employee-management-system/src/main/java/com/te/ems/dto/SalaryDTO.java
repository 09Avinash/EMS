package com.te.ems.dto;

import java.time.LocalDate;

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
public class SalaryDTO {
	private double salaryAmount;
	private LocalDate startDate;
	private LocalDate endDate;

	private EmployeeDTO employee;
}
